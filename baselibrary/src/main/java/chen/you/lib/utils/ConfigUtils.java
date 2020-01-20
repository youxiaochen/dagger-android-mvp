package chen.you.lib.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;

import java.util.List;

/**
 * Created by you on 16/9/23.
 * 配置辅助类  Resources.getSystem()
 */
public class ConfigUtils {

    private ConfigUtils() {
    }

    /**
     * 网络是否连接
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null) {
            return networkInfo.isAvailable();
        }
        return false;
    }

    /**
     * @param context
     * @param packageName
     * @return
     */
    public static PackageInfo getPackageInfo(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        PackageInfo pkgInfo = null;
        try {
            pkgInfo = pm.getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
        }

        return pkgInfo;
    }

    /**
     * 获得当前进程的名字
     *
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null || runningApps.isEmpty()) {
            return null;
        }
        int pid = android.os.Process.myPid();
        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return null;
    }

    /**
     * 退出程序
     */
    public static void killCurrentProcess() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }

    /**
     * 4.4以上版本
     */
    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    /**
     * 5.0版本
     */
    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * 获取状态栏高度
     */
    public static final int getStatusHeight(Context context) {
        int result = 0;
        int resId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            result = context.getResources().getDimensionPixelOffset(resId);
        }
        return result;
    }

    /**
     * 设置activity statusbar颜色, 此方法必须在activitysetContentView之后才可以见效果
     *
     * @param activity
     * @param statusColor
     */
    public static void setStatusBarColor(Activity activity, int statusColor) {
        Window window = activity.getWindow();
        ViewGroup root = activity.findViewById(Window.ID_ANDROID_CONTENT);
        if (hasKitKat()) {//4.4以上才支持
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup decorView = (ViewGroup) window.getDecorView();
            Object tag = decorView.getTag();
            if (tag instanceof Boolean && (Boolean) tag) {
                View mStatusBarView = decorView.getChildAt(0);
                if (mStatusBarView != null) {
                    mStatusBarView.setBackgroundColor(statusColor);
                }
            } else {
                int statusBarHeight = getStatusHeight(activity);
                View contentChild = root.getChildAt(0);
                if (contentChild != null) {
                    ViewCompat.setFitsSystemWindows(contentChild, false);
                    LayoutParams lp = (LayoutParams) contentChild.getLayoutParams();
                    lp.topMargin += statusBarHeight;
                    contentChild.setLayoutParams(lp);
                }
                View mStatusBarView = new View(activity);
                LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, statusBarHeight);
                layoutParams.gravity = Gravity.TOP;
                mStatusBarView.setLayoutParams(layoutParams);
                mStatusBarView.setBackgroundColor(statusColor);
                decorView.addView(mStatusBarView, 0);
                decorView.setTag(true);
            }
        }
    }

    /**
     * 由于全屏时转非全屏时界面中的布局大小不能改变,所以不能使用流行的在windows中添加一个
     * Status 高度的控件来填充内容,  直接使用toolbar设置padding效果
     * @param activity
     * @param toolbar
     */
    public static void setStatusBarColor(Activity activity, Toolbar toolbar) {
        if (hasKitKat()) {  //设置显示toolbar时的样式
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (toolbar.getTag() == null ) {
                ViewGroup.LayoutParams params = toolbar.getLayoutParams();
                int statusHeight = getStatusHeight(activity);
                params.height += statusHeight;
                toolbar.setLayoutParams(params);
                toolbar.setPadding(toolbar.getPaddingLeft(), toolbar.getPaddingTop() + statusHeight,
                        toolbar.getPaddingRight(), toolbar.getPaddingBottom());
                toolbar.setTag(true);
            }
        }
    }

}
