package chen.you.lib.base;

import chen.you.lib.utils.ConfigUtils;
import dagger.android.support.DaggerApplication;

/**
 * Created by Max on 2017/1/2.
 */

public abstract class BaseApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        String processName = ConfigUtils.getCurProcessName(this);
        if (processName != null && processName.equals(getPackageName())) {
            init();


            //这里可以做一些初始化
        }
    }

    /**
     * 初始化
     */
    protected abstract void init();

}
