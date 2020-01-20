package chen.you.mvpapp.mvp;

import javax.inject.Singleton;

import chen.you.mvpapp.mvp.ui.ActivitysBuilder;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by You on 2019/1/13.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivitysBuilder.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }

}
