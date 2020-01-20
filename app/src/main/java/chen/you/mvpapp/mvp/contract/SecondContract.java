package chen.you.mvpapp.mvp.contract;

import chen.you.lib.daggermvp.IView;

/**
 * Created by You on 2019/1/15.
 */

public interface SecondContract {

    interface View extends IView {
        void setResult(String text);
    }

    interface Presenter {
        void request();
    }

}
