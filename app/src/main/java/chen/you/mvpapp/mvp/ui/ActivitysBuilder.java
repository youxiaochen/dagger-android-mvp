package chen.you.mvpapp.mvp.ui;

import chen.you.lib.daggermvp.ActivityScope;
import chen.you.mvpapp.mvp.ui.module.FourActivityModule;
import chen.you.mvpapp.mvp.ui.module.MainActivityModule;
import chen.you.mvpapp.mvp.ui.module.SecondActivityModule;
import chen.you.mvpapp.mvp.ui.module.ThreeActivityModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by You on 2019/1/14.
 */
@Module
public interface ActivitysBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    MainActivity injectMainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = SecondActivityModule.class)
    SecondActivity injectSecondActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = ThreeActivityModule.class)
    ThreeActivity injectThreeActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = FourActivityModule.class)
    FourActivity injectFourActivity();

}
