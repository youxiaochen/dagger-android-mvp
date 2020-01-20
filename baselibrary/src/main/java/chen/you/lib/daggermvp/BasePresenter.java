package chen.you.lib.daggermvp;

import android.arch.lifecycle.LifecycleOwner;

/**
 * Created by You on 2018/1/15.
 */

public abstract class BasePresenter<V extends IView> implements ILifecycleObserver {

    /**
     * View
     */
    private final V iView;

    public BasePresenter(V iView) {
        this.iView = iView;
        if (iView instanceof LifecycleOwner) {
            ((LifecycleOwner) iView).getLifecycle().addObserver(this);
        }
    }

    protected final V getView() {
        return iView;
    }

    @Override
    public void onCreate(LifecycleOwner owner) {
    }

    @Override
    public void onStart(LifecycleOwner owner) {
    }

    @Override
    public void onStop(LifecycleOwner owner) {
    }

    @Override
    public void onResume(LifecycleOwner owner) {
    }

    @Override
    public void onPause(LifecycleOwner owner) {
    }

    @Override
    public void onDestory(LifecycleOwner owner) {
        if (owner != null) {
            owner.getLifecycle().removeObserver(this);
        }
    }

}
