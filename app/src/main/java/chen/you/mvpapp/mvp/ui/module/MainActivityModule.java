package chen.you.mvpapp.mvp.ui.module;

import chen.you.lib.daggermvp.BaseActivityModule;
import chen.you.mvpapp.mvp.contract.MainContract;
import chen.you.mvpapp.mvp.ui.MainActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by You on 2019/1/14.
 */

@Module
public class MainActivityModule extends BaseActivityModule<MainActivity> {

    /**
     * 不推荐使用这种方式注入
     * @param activity
     * @return
     */
    @Provides
    MainContract.View mainView(MainActivity activity) {
        return activity;
    }

}
