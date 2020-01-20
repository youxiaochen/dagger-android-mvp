package chen.you.mvpapp.mvp.model;

import javax.inject.Inject;

import chen.you.lib.utils.LogUtils;

/**
 * Created by You on 2019/1/4.
 */

public class MainModel {

    @Inject
    public MainModel() {
    }

    public void login(String name, String password) {
        LogUtils.i("main login  " + name + "  " + password);
    }

}
