package chen.you.lib.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import chen.you.lib.R;
import chen.you.lib.daggermvp.IView;
import chen.you.lib.dialog.ProgressDialog;
import chen.you.lib.utils.ConfigUtils;
import chen.you.lib.utils.ToastUtils;

/**
 * Created by Max on 2017/1/2.
 */

public abstract class BaseActivity extends AppCompatActivity implements IView {

    /**
     * BaseActivity引用
     */
    protected BaseActivity mContext;
    /**
     * 进度弹窗
     */
    private ProgressDialog progressDialog;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        View container = getLayoutInflater().inflate(getLayoutResId(), null);
        initContainerView(container);
        setContentView(container);

        unbinder = ButterKnife.bind(this);
        initViews(container);
        onViewCreated(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }

    /**
     * 初始化根目录控件
     */
    void initContainerView(View container) {
        //nothing
    }

    /**
     * activity布局内容资源id
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化控件
     * @param root activity根目录
     */
    protected void initViews(View root) {
    }

    /**
     * 布局加载完成后调用
     */
    protected void onViewCreated(Bundle savedInstanceState) {
    }

    @Override
    public final void showLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(mContext);
        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public final void hideLoading() {
        if (isShowLoading()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public final boolean isShowLoading() {
        return progressDialog != null && progressDialog.isShowing();
    }

    /**
     * 网络是否连接,并且toast提示
     * @return
     */
    protected final boolean isNetworkConnected() {
        boolean isNetworkConnected = ConfigUtils.isNetworkConnected(mContext);
        if (!isNetworkConnected) {
            ToastUtils.showToast(mContext, R.string.lib_loadNetworkError);
        }
        return isNetworkConnected;
    }

}
