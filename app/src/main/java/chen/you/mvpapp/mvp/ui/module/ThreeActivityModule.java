package chen.you.mvpapp.mvp.ui.module;

import android.support.v7.widget.LinearLayoutManager;

import chen.you.lib.daggermvp.BaseActivityModule;
import chen.you.mvpapp.mvp.ui.ThreeActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by You on 2019/1/16.
 */
@Module
public class ThreeActivityModule extends BaseActivityModule<ThreeActivity> {

    @Provides
    LinearLayoutManager layoutManager(ThreeActivity activity) {
        return new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
    }

}
