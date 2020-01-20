package chen.you.mvpapp.mvp.fragment;

import android.view.View;

import chen.you.lib.base.BaseDaggerFragment;
import chen.you.mvpapp.R;

/**
 * Created by You on 2019/1/4.
 */

public class TestFragment extends BaseDaggerFragment {

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initViews(View root) {
        getChildFragmentManager().beginTransaction().add(R.id.fl2, TestChildFragment.newInstance()).commitAllowingStateLoss();
    }

}
