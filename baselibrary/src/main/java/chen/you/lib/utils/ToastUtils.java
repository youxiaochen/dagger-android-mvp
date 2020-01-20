package chen.you.lib.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by you on 2019/7/16.
 */

public class ToastUtils {

    private ToastUtils() {}

    public static void showToast(Context context, int strRes) {
        Toast.makeText(context, strRes, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context, int strRes) {
        Toast.makeText(context, strRes, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

}
