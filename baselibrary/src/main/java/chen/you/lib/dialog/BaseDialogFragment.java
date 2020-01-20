package chen.you.lib.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import chen.you.lib.R;

/**
 * Created by Max on 2017/1/5.
 *  建议使用此Fragment
 */

public abstract class BaseDialogFragment extends DialogFragment {
    /**
     * ButterKnife
     */
    private Unbinder unbinder;

    /**
     * 样式
     * @return
     */
    @Override
    public int getTheme() {
        return R.style.baseDialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = getLayoutInflater().inflate(getLayoutResId(), container, false);
        unbinder = ButterKnife.bind(this, root);
        initViews(root);
        return root;
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
    }

    /**
     * fragment布局资源id
     * @return
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化控件
     * @param root fragment根目录
     */
    protected void initViews(View root) {
    }

//    @Override
//    public void onDismiss(DialogInterface dialog) {
//        if (listener != null) {
//            listener.onDismiss(this);
//        }
//        super.onDismiss(dialog);
//    }
//
//    public void setOnDismissListener(OnDismissListener listener) {
//        this.listener = listener;
//    }
//
//    private OnDismissListener listener;
//
//    public interface OnDismissListener {
//
//        void onDismiss(BaseDialogFragment f);
//    }
}
