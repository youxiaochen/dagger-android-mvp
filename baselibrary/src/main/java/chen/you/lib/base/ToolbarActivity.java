package chen.you.lib.base;

import android.support.v7.widget.Toolbar;
import android.view.View;

import chen.you.lib.R;

/**
 * Created by You on 2019/1/15.
 * ToolbarActivity 布局中必须要有Toolbar  <include layout="@layout/lib_toolbar"/>
 * Actionbar布局 getActionBarResId()
 */

public abstract class ToolbarActivity extends BaseActivity {

    protected Toolbar mToolbar;

    @Override
    void initContainerView(View container) {
        mToolbar = container.findViewById(R.id.mToolbar);
        getLayoutInflater().inflate(getActionBarResId(), mToolbar);
        setSupportActionBar(mToolbar);
    }

    /**
     * ActionBar布局内容资源id
     */
    protected abstract int getActionBarResId();

}
