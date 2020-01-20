package chen.you.lib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import chen.you.lib.R;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by You on 2019/1/15.
 * ToolbarActivity 布局中必须要有Toolbar  <include layout="@layout/lib_toolbar"/>
 * Actionbar布局 getActionBarResId()
 */

public abstract class ToolbarDaggerActivity extends BaseActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> supportFragmentInjector;

    protected Toolbar mToolbar;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    void initContainerView(View container) {
        mToolbar = container.findViewById(R.id.mToolbar);
        getLayoutInflater().inflate(getActionBarResId(), mToolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    public final AndroidInjector<Fragment> supportFragmentInjector() {
        return this.supportFragmentInjector;
    }

    /**
     * ActionBar布局内容资源id
     */
    protected abstract int getActionBarResId();

}
