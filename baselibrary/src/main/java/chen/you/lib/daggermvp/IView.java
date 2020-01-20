package chen.you.lib.daggermvp;

/**
 * Created by You on 2019/1/18.
 */

public interface IView {

    /**
     * 弹窗加载进度
     */
    void showLoading();

    /**
     * 隐藏弹窗加载
     */
    void hideLoading();

    /**
     * 是否正在加载
     * @return
     */
    boolean isShowLoading();
}
