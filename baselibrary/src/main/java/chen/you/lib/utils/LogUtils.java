package chen.you.lib.utils;

import android.util.Log;

import chen.you.lib.Config;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by you on 2016/8/2.
 * Log打印辅助类
 */

public class LogUtils {

    private LogUtils() {
    }

    private static boolean IS_DEBUG = !Config.isOnLine;

    private static final String TAG = Config.APPNAME;

    public static void e(String tag, String msg) {
        if (IS_DEBUG) Log.e(tag, msg);
    }

    public static void e(String tag, Throwable e) {
        e(tag, throwableToString(e));
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(Throwable e) {
        e(TAG, e);
    }

    public static void i(String tag, String msg) {
        if (IS_DEBUG) Log.i(tag, msg);
    }

    public static void i(String tag, Throwable e) {
        i(tag, throwableToString(e));
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void i(Throwable e) {
        i(TAG, e);
    }

    public static void d(String tag, String msg) {
        if (IS_DEBUG) Log.d(tag, msg);
    }

    public static void d(String tag, Throwable e) {
        d(tag, throwableToString(e));
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(Throwable e) {
        d(TAG, throwableToString(e));
    }

    public static void v(String tag, String msg) {
        if (IS_DEBUG) Log.v(tag, msg);
    }

    public static void v(String tag, Throwable e) {
        v(tag, throwableToString(e));
    }

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void v(Throwable e) {
        v(TAG, throwableToString(e));
    }

    public static void w(String tag, String msg) {
        if (IS_DEBUG) Log.w(tag, msg);
    }

    public static void w(String tag, Throwable e) {
        w(tag, throwableToString(e));
    }

    public static void w(String msg) {
        w(TAG, msg);
    }

    public static void w(Throwable e) {
        w(TAG, throwableToString(e));
    }

    /**
     * 打印异常信息到log中
     * @param throwable
     * @return
     */
    private static String throwableToString(Throwable throwable) {
        if (throwable == null) {
            return "throwable is null";
        }
        Writer info = new StringWriter();
        PrintWriter printWriter = new PrintWriter(info);
        throwable.printStackTrace(printWriter);
        return info.toString();
    }

}
