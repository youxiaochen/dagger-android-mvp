package chen.you.mvpapp.mvp;

import android.app.Application;

/**
 * Created by You on 2019/1/17.
 */

public class UserInfoManager {

    private Application application;

    private static UserInfoManager instance;

    private UserInfoManager(Application application) {
        this.application = application;
    }

    public static UserInfoManager getInstance(Application app) {
        if (instance == null) {
            synchronized (UserInfoManager.class) {
                if (instance == null) {
                    instance = new UserInfoManager(app);
                }
            }
        }
        return instance;
    }

}
