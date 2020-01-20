package chen.you.mvpapp.mvp.ui;


import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import chen.you.lib.base.ToolbarDaggerActivity;
import chen.you.lib.perm.PermissionMustCallback;
import chen.you.lib.perm.RxPermissions;
import chen.you.lib.rx.RxUtils;
import chen.you.lib.utils.ToastUtils;
import chen.you.mvpapp.R;
import chen.you.mvpapp.mvp.contract.MainContract;
import chen.you.mvpapp.mvp.presenter.MainPresenter;
import dagger.Lazy;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends ToolbarDaggerActivity implements MainContract.View {

    @BindView(R.id.tv_title)
    public TextView tv_title;

    /**
     * 注意RxPermision一定要用Lazy的方式来注入, 包括Fragment中注入此属性都需要
     */
    @Inject
    Lazy<RxPermissions> permissionsLazy;

    @BindView(R.id.bt1)
    public View bt1;
    @BindView(R.id.bt2)
    public View bt2;
    @BindView(R.id.bt3)
    public View bt3;
    @BindView(R.id.bt4)
    public View bt4;
    @BindView(R.id.bt5)
    public View bt5;

    @Inject
    MainPresenter presenter;

    private Disposable viewClickDisposable;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getActionBarResId() {
        return R.layout.actionbar_public;
    }

    @Override
    protected void initViews(View root) {
        //防抖点击
        viewClickDisposable = RxUtils.click(bt1, bt2, bt3, bt4, bt5).subscribe(new Consumer<View>() {
            @Override
            public void accept(View v) throws Exception {
                switch (v.getId()) {
                    case R.id.bt1:
                        SecondActivity.lanuch(mContext);
                        break;
                    case R.id.bt2:
                        ThreeActivity.lanuch(mContext);
                        break;
                    case R.id.bt3:
                        FourActivity.lanuch(mContext);
                        break;
                    case R.id.bt4:
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
                    case R.id.bt5:
                        presenter.login();
                        break;
                }
            }
        });
    }

    @OnClick(R.id.tv_return)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_return:
                finish();
                break;
        }
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        tv_title.setText("MainActivity");
    }

    @Override
    protected void onDestroy() {
        RxUtils.dispose(viewClickDisposable);
        super.onDestroy();
    }

    @Override
    public String getName() {
        return "Main Test Name";
    }

    @Override
    public String getPassword() {
        return "Main Test Paswword";
    }
}
