package chen.you.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;

import chen.you.lib.R;

/**
 * Created by Max on 2017/1/5.
 */

public class ProgressDialog extends Dialog {

    public ProgressDialog(Context context) {
        super(context, R.style.baseDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lib_dialog_loading);
        setCanceledOnTouchOutside(false);
        this.getWindow().setBackgroundDrawableResource(R.drawable.lib_bg_pbloading);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
