package chen.you.lib.rx;

import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import chen.you.lib.utils.LogUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;

/**
 * Created by you on 2016/10/19.
 * 防抖点击事件绑定  可以参照rxbinding
 *
 *
 ViewClickOnSubscribe click = new ViewClickOnSubscribe();
 click.addOnClickListener(tv_test);
 click.addOnClickListener(tv_test1);
 click.addOnClickListener(tv_test2);

 subscription = Observable.create(click).throttleFirst(500 , TimeUnit.MILLISECONDS ).subscribe(new Action1<View>() {
    @Override
    public void call(View view) {
        switch (view.getId()) {
            case R.id.tv_test:
                Log.i("you", "test");
                break;
            case R.id.tv_test1:
                Log.i("you", "test1");
                break;
            }
        }
    });

 Subscription subscription;

 @Override
 protected void onDestroy() {
    super.onDestroy();
    RxUtils.unsubscribe();
 }

 */

public class ViewClickOnSubscribe implements ObservableOnSubscribe<View> {

    /**
     * 注册防抖点击的控件
     */
    private List<View> clickViews = new ArrayList<View>();

    /**
     * 添加控件点击事件
     * @param views
     */
    public void addOnClickListener(View... views) {
        if (views == null) return;
        for (View v : views) {
            clickViews.add(v);
        }
    }

    @Override
    public void subscribe(final ObservableEmitter<View> emitter) throws Exception {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emitter.isDisposed()) {
                    emitter.onNext(v);
                }
            }
        };
        for (View v : clickViews) {
            v.setOnClickListener(listener);
        }
        emitter.setCancellable(new Cancellable() {
            @Override
            public void cancel() throws Exception {
                LogUtils.i("Rx diso cancel");
                Iterator<View> iterator = clickViews.iterator();
                while (iterator.hasNext()) {
                    iterator.next().setOnClickListener(null);
                    iterator.remove();
                }
            }
        });
    }

}
