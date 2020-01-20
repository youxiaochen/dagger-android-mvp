package chen.you.mvpapp.mvp;

import chen.you.lib.base.BaseApp;
import dagger.android.AndroidInjector;

/**
 * Created by Max on 2018/1/3.
 */


public class App extends BaseApp {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    @Override
    protected void init() {
        //LogUtils.i("app " + app);
    }

    @Override
    protected AndroidInjector<App> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

}
