package chen.you.mvpapp.mvp.ui.module;

import chen.you.lib.daggermvp.BaseActivityModule;
import chen.you.mvpapp.mvp.presenter.SecondPresenter;
import chen.you.mvpapp.mvp.ui.SecondActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by You on 2019/1/15.
 */

@Module
public class SecondActivityModule extends BaseActivityModule<SecondActivity> {

    @Provides
    SecondPresenter presenter(SecondActivity activity) {
        return new SecondPresenter(activity);
    }

}
