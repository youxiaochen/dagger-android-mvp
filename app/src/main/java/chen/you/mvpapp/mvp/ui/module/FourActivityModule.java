package chen.you.mvpapp.mvp.ui.module;

import chen.you.lib.daggermvp.BaseActivityModule;
import chen.you.mvpapp.mvp.fragment.builder.TestFragmentBuilder;
import chen.you.mvpapp.mvp.ui.FourActivity;
import dagger.Module;

/**
 * Created by You on 2019/1/19.
 */
@Module(includes = TestFragmentBuilder.class)
public class FourActivityModule extends BaseActivityModule<FourActivity> {

}
