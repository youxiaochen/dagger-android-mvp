package chen.you.mvpapp.mvp.fragment.builder;

import chen.you.lib.daggermvp.FragmentScope;
import chen.you.mvpapp.mvp.fragment.TestFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by You on 2019/1/15.
 */

@Module
public interface TestFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector(modules = {TestChildFragmentBuilder.class})
    TestFragment injectTestFragment();

}
