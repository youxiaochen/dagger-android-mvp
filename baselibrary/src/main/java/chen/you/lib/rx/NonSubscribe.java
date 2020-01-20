package chen.you.lib.rx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by you on 2019/7/30.
 */

public abstract class NonSubscribe<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable disposable) {
        //nothing
    }

    @Override
    public void onError(Throwable e) {
        //nothing
    }

    @Override
    public void onComplete() {
        //nothing
    }

}
