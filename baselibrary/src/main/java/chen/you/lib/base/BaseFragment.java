package chen.you.lib.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public abstract class BaseFragment extends Fragment implements IView {

    /**
     * Activity引用
     */
    protected Activity mContext;
    /**
     * ButterKnife
     */
    private Unbinder unbinder;
    /**
     * 控件是否初始化好
     */
    protected boolean isViewInited;
    /**
     * 进度弹窗
     */
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = getLayoutInflater().inflate(getLayoutResId(), container, false);
        unbinder = ButterKnife.bind(this, root);
        initViews(root);
        isViewInited = true;
        return root;
    }

    @Override
    public void onDestroyView() {
        isViewInited = false;
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
    }

    /**
     * 初始化控件
     * @param root fragment根目录
     */
    protected void initViews(View root) {
    }

    /**
     * fragment布局资源id
     * @return
     */
    protected abstract int getLayoutResId();

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
