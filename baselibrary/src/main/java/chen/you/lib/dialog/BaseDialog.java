package chen.you.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import chen.you.lib.R;

/**
 * Created by Max on 2017/1/5.
 * Dialog只生成一次多次显示使用,用此Dialog
 */

public abstract class BaseDialog extends Dialog {

    /**
     * dialog布局资源
     */
    protected int layoutResId;

    private Unbinder unbinder;

    public BaseDialog(Context context, int layoutResId) {
        this(context, R.style.baseDialog, layoutResId);
    }

    public BaseDialog(Context context, int themeResId, int layoutResId) {
        super(context, themeResId);
        this.layoutResId = layoutResId;
    }

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = LayoutInflater.from(getContext()).inflate(layoutResId, null);
        setContentView(contentView);

        unbinder = ButterKnife.bind(this);

        initViews(contentView);

        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        initDialowWindow(lp);
        this.getWindow().setAttributes(lp);
    }

    /**
     * 手动的解除绑定
     */
    public void destory() {
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    /**
     * 初始化成员属性
     * @param root
     */
    protected void initViews(View root) {
    }

    /**
     * 初始化dialog显示参数
     * @param lp
     */
    protected void initDialowWindow(WindowManager.LayoutParams lp) {
        getWindow().setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.lib_bg_public_dialog));
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        lp.width = wm.getDefaultDisplay().getWidth() * 4 / 5;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
    }

}
