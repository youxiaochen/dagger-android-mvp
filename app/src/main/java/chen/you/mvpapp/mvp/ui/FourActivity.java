package chen.you.mvpapp.mvp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import chen.you.lib.base.ToolbarDaggerActivity;
import chen.you.mvpapp.R;
import chen.you.mvpapp.mvp.fragment.TestFragment;

/**
 * Created by You on 2019/1/18.
 */

public class FourActivity extends ToolbarDaggerActivity {

    @BindView(R.id.tv_title)
    public TextView tv_title;

    public static void lanuch(Context context) {
        context.startActivity(new Intent(context, FourActivity.class));
    }

    @Override
    protected int getActionBarResId() {
        return R.layout.actionbar_public;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_four;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        tv_title.setText("Activity多层嵌套Fragment注入");
        getSupportFragmentManager().beginTransaction().add(R.id.fl, TestFragment.newInstance()).commitAllowingStateLoss();
    }

    @OnClick({R.id.tv_return})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_return:
                finish();
                break;
        }
    }
}
