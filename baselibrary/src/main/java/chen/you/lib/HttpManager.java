package chen.you.lib;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by You on 2019/1/6.
 */

public final class HttpManager {
    /**
     * 默认超时时间
     */
    public static final int DEF_MILL_TIMEOUT = 10;
    /**
     * retrofit instance, 界面数据展示
     */
    private Retrofit retrofit;

    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null) {
                    instance = new HttpManager();
                }
            }
        }
        return instance;
    }

    private HttpManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .proxy(Proxy.NO_PROXY)
                .connectTimeout(DEF_MILL_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEF_MILL_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEF_MILL_TIMEOUT, TimeUnit.SECONDS);
        if (!Config.isOnLine) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        OkHttpClient client = builder.build();

        retrofit = creatRetrofit("https://www.baidu.com/", client);
    }

    private static Retrofit creatRetrofit(String service, OkHttpClient client) {
        return new Retrofit.Builder().client(client)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .baseUrl(service)
                .build();
    }

    public <T> T create(Class<T> t) {
        return this.retrofit.create(t);
    }

}
