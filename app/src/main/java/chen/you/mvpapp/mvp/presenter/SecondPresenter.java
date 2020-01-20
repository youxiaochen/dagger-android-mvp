package chen.you.mvpapp.mvp.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

import javax.inject.Inject;

import chen.you.lib.HttpManager;
import chen.you.lib.daggermvp.BasePresenter;
import chen.you.lib.rx.RxUtils;
import chen.you.lib.utils.LogUtils;
import chen.you.mvpapp.mvp.contract.SecondContract;
import chen.you.mvpapp.mvp.model.SecondModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by You on 2019/1/15.
 */

public class SecondPresenter extends BasePresenter<SecondContract.View> implements SecondContract.Presenter {

    SecondModel model;

    Disposable requestDisposable;

//    这里注入将注入不了, 构造中没有注入
//    @Inject
//    Context context;

    public SecondPresenter(SecondContract.View iView) {
        super(iView);
    }

    @Override
    public void onCreate(LifecycleOwner owner) {
        model = HttpManager.getInstance().create(SecondModel.class);
    }

    @Override
    public void request() {
        LogUtils.i("SecondPresenter " + getView() + "  " + this);
        model.request("https://www.baidu.com/")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        requestDisposable = disposable;
                        getView().showLoading();
                    }

                    @Override
                    public void onNext(String s) {
                        getView().hideLoading();
                        getView().setResult(s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        getView().hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        getView().hideLoading();
                    }
                });
    }

    @Override
    public void onDestory(LifecycleOwner owner) {
        RxUtils.dispose(requestDisposable);
        super.onDestory(owner);
    }
}
