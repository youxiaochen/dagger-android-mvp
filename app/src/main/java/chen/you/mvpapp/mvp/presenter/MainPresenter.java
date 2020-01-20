package chen.you.mvpapp.mvp.presenter;

import javax.inject.Inject;

import chen.you.lib.daggermvp.BasePresenter;
import chen.you.lib.utils.LogUtils;
import chen.you.mvpapp.mvp.App;
import chen.you.mvpapp.mvp.contract.MainContract;
import chen.you.mvpapp.mvp.model.MainModel;

/**
 * Created by You on 2019/1/4.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    MainModel model;

    /**
     * 这里测试注入的app, 这里要注入的前提是MainPresenter是构造函数Inject注入的
     */
    @Inject
    App app;

    @Inject
    public MainPresenter(MainContract.View iView) {
        super(iView);
    }

    @Override
    public void login() {
        LogUtils.i("MainPresenter test app " + app +"   " + getView()+"  " + this);
        model.login(getView().getName(), getView().getPassword());
    }

}
