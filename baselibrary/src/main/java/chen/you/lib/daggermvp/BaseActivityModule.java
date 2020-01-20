package chen.you.lib.daggermvp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import chen.you.lib.base.BaseActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by You on 2019/1/16.
 */
@Module
public abstract class BaseActivityModule<A extends BaseActivity> {

    @ActivityScope
    @Provides
    protected Context activityContext(A baseActivity) {
        return baseActivity;
    }

    @ActivityScope
    @Provides
    protected Activity activity(A baseActivity) {
        return baseActivity;
    }

    @ActivityScope
    @Provides
    protected AppCompatActivity appCompatActivity(A baseActivity) {
        return baseActivity;
    }

}
