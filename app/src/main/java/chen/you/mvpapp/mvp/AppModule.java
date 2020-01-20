package chen.you.mvpapp.mvp;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by You on 2019/1/14.
 */
@Module
public class AppModule {

    /**
     * 可用于构造函数需要参数Application的注解
     * @param app
     * @return
     */
    @Provides
    @Singleton
    Application application(App app) {
        return app;
    }

    @Provides
    @Singleton
    @Named("App")//不与ActivityModule的Context冲突
    Context appContext(App app) {
        return app;
    }

    @Provides
    @Singleton
    UserInfoManager userInfoManager(Application app) {
        return UserInfoManager.getInstance(app);
    }

}
