package chen.you.mvpapp.mvp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import chen.you.lib.base.BaseDaggerActivity;
import chen.you.lib.base.ToolbarDaggerActivity;
import chen.you.lib.perm.RxPermissions;
import chen.you.lib.utils.LogUtils;
import chen.you.mvpapp.R;
import chen.you.mvpapp.mvp.contract.SecondContract;
import chen.you.mvpapp.mvp.fragment.TestFragment;
import chen.you.mvpapp.mvp.presenter.SecondPresenter;
import dagger.Lazy;

/**
 * Created by You on 2019/1/15.
 */

public class SecondActivity extends ToolbarDaggerActivity implements SecondContract.View {

    @BindView(R.id.tv_title)
    public TextView tv_title;

    @Inject
    SecondPresenter presenter;

    @BindView(R.id.tv_result)
    public TextView tv_result;

    public static void lanuch(Context context) {
        context.startActivity(new Intent(context, SecondActivity.class));
    }

    @OnClick({R.id.tv_return, R.id.bt})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                presenter.request();
                break;
            case R.id.tv_return:
                finish();
                break;
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_second;
    }

    @Override
    protected int getActionBarResId() {
        return R.layout.actionbar_public;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        tv_title.setText("Presenter test");
    }

    @Override
    public void setResult(String text) {
        tv_result.setText(text);
    }
}
