package chen.you.mvpapp.mvp.contract;

import chen.you.lib.daggermvp.IView;

/**
 * Created by You on 2019/1/4.
 */

public interface MainContract {

    interface View extends IView {
        String getName();
        String getPassword();
    }

    interface Presenter {
        void login();
    }

}
