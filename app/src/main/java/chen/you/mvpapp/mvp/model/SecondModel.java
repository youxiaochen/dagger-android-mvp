package chen.you.mvpapp.mvp.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by You on 2019/1/15.
 */

public interface SecondModel {

    @GET
    Observable<String> request(@Url String url);
}
