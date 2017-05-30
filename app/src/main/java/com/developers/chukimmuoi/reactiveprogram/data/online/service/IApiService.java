package com.developers.chukimmuoi.reactiveprogram.data.online.service;

import com.developers.chukimmuoi.reactiveprogram.object.Result;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : ReactiveProgram
 * Created by chukimmuoi on 5/7/17.
 */

public interface IApiService {
    // eg: @Url: DO NOT start with "/".

    /**
     * @see {https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit}
     */
//    @Headers({"Cache-Control: max-age=640000", "User-Agent: Reactive Program"})
    @FormUrlEncoded
    @POST("song/listFromLastUpdate?")
    Call<Result> listFromLastUpdate(@FieldMap Map<String, String> map);

    @GET("song/listFromLastUpdate?deviceId=PX4KI5RC&number=3000&page=1&lastUpdate=1474390800000&sign=2507f03649db54a6fd00f920fd6d56a736e4bf11e94bad88e4b719af4fd73b64")
    Call<Result> listFromLastUpdateMax();

    @GET("song/listFromLastUpdate?deviceId=PX4KI5RC&number=50&page=1&lastUpdate=1474390800000&sign=7ce0c550e8d4abfca675661f80a15b739dbca2fefc2fbc82d7cf0d8b1c3f1bf5")
    Observable<Result> listFromLastUpdateRx();

    @GET("song/listFromLastUpdate?deviceId=PX4KI5RC&number=3000&page=1&lastUpdate=1474390800000&sign=2507f03649db54a6fd00f920fd6d56a736e4bf11e94bad88e4b719af4fd73b64")
    Observable<Result> listFromLastUpdateMaxRx();

    @GET("song/listFromLastUpdate?deviceId=PX4KI5RC&number=50&page=1&lastUpdate=1474390800000&sign=7ce0c550e8d4abfca675661f80a15b739dbca2fefc2fbc82d7cf0d8b1c3f1bf5")
    Call<ResponseBody> listFromLastUpdate();
}
