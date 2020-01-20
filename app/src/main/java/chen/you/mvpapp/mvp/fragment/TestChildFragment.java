package chen.you.mvpapp.mvp.fragment;

import android.Manifest;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import chen.you.lib.base.BaseDaggerFragment;
import chen.you.lib.perm.PermissionMustCallback;
import chen.you.lib.perm.RxPermissions;
import chen.you.lib.utils.ToastUtils;
import chen.you.mvpapp.R;
import chen.you.mvpapp.mvp.contract.MainContract;
import chen.you.mvpapp.mvp.contract.SecondContract;
import chen.you.mvpapp.mvp.presenter.MainPresenter;
import chen.you.mvpapp.mvp.presenter.SecondPresenter;
import dagger.Lazy;

/**
 * Created by You on 2019/1/15.
 */

public class TestChildFragment extends BaseDaggerFragment implements MainContract.View, SecondContract.View {

    @Inject
    Lazy<RxPermissions> permissionsLazy;

    @Inject
    MainPresenter mainPresenter;

    @Inject
    SecondPresenter secondPresenter;

    @BindView(R.id.et_name)
    public EditText et_name;
    @BindView(R.id.et_pwd)
    public EditText et_pwd;

    @BindView(R.id.tv)
    public TextView tv;

    public static TestChildFragment newInstance() {
        return new TestChildFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_testchild;
    }

    @OnClick({R.id.bt1, R.id.bt2, R.id.bt3})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                mainPresenter.login();
                break;
            case R.id.bt2:
                secondPresenter.request();
                break;
            case R.id.bt3:
                permissionsLazy.get().requestEach(Manifest.permission.READ_PHONE_STATE).subscribe(new PermissionMustCallback() {
                    @Override
                    protected void permissionCallback(boolean hasPermission) {
                        if (hasPermission) {
                            ToastUtils.showToast(mContext, "权限有了");
                        } else {
                            ToastUtils.showToast(mContext, "权限没有");
                        }
                    }
                });
                break;
        }
    }

    @Override
    public String getName() {
        return et_name.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_pwd.getText().toString();
    }

    @Override
    public void setResult(String text) {
        tv.setText(text);
    }

}
