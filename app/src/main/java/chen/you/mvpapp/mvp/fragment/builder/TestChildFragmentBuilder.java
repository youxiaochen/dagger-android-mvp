package chen.you.mvpapp.mvp.fragment.builder;

import chen.you.lib.daggermvp.FragmentChildScope;
import chen.you.mvpapp.mvp.fragment.TestChildFragment;
import chen.you.mvpapp.mvp.fragment.module.TestChildFragmentModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by You on 2019/1/15.
 */

@Module
public interface TestChildFragmentBuilder {

    @FragmentChildScope
    @ContributesAndroidInjector(modules = TestChildFragmentModule.class)
    TestChildFragment injectTestFragment();
}
