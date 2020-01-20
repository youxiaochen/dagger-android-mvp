package chen.you.mvpapp.mvp.bean;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by you on 2019/6/10.
 */

public final class DataResult<T> {

    @Expose
    public int code;

    @Expose
    public String msg;

    @Expose
    public T data;

    public final boolean success() {
        return code == 200 && data != null;
    }

    /**
     * 列表是否为
     * @return
     */
    public final boolean isListEmpty() {
        if (success() && data instanceof List) {
            return ((List) data).isEmpty();
        }
        return true;
    }

}
