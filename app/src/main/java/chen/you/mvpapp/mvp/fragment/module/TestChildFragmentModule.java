package chen.you.mvpapp.mvp.fragment.module;

import chen.you.lib.daggermvp.FragmentChildScope;
import chen.you.mvpapp.mvp.contract.MainContract;
import chen.you.mvpapp.mvp.fragment.TestChildFragment;
import chen.you.mvpapp.mvp.presenter.SecondPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by You on 2019/1/19.
 */

@Module
public class TestChildFragmentModule {

    @FragmentChildScope
    @Provides
    MainContract.View mainView(TestChildFragment f) {
        return f;
    }

    @FragmentChildScope
    @Provides
    SecondPresenter secondView(TestChildFragment f) {
        return new SecondPresenter(f);
    }

}
