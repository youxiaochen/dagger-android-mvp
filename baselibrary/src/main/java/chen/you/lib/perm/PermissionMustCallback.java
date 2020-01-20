package chen.you.lib.perm;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by you on 2018/4/19.
 * 必要的权限请求,所请求的权限必须获取
 */

public abstract class PermissionMustCallback implements Observer<Permission> {

    private boolean hasPermission = true;

    @Override
    public void onSubscribe(Disposable disposable) {
    }

    @Override
    public void onComplete() {
        permissionCallback(hasPermission);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(Permission permission) {
        hasPermission &= permission.granted;
    }

    protected abstract void permissionCallback(boolean hasPermission);

}
