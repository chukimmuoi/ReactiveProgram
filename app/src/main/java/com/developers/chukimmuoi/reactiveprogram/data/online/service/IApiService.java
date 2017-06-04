package com.developers.chukimmuoi.reactiveprogram.data.online.service;

import com.developers.chukimmuoi.reactiveprogram.constants.IConstants;
import com.developers.chukimmuoi.reactiveprogram.object.Result;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    @FormUrlEncoded
    @POST("song/listFromLastUpdate?")
    Call<Result> listFromLastUpdate(@FieldMap Map<String, String> map);

    @GET("song/listFromLastUpdate?")
    Call<Result> listFromLastUpdate(@Query(IConstants.DEVICE_ID_PARAM)   String deviceId,
                                    @Query(IConstants.NUMBER_PARAM)      int number,
                                    @Query(IConstants.PAGE_PARAM)        int page,
                                    @Query(IConstants.LAST_UPDATE_PARAM) long lastUpdate,
                                    @Query(IConstants.SIGN_PARAM)        String sign);

    @FormUrlEncoded
    @POST("song/listFromLastUpdate?")
    Observable<Result> listFromLastUpdateRx(@FieldMap Map<String, String> map);

    @GET("song/listFromLastUpdate?")
    Observable<Result> listFromLastUpdateRx(@Query(IConstants.DEVICE_ID_PARAM)   String deviceId,
                                            @Query(IConstants.NUMBER_PARAM)      int number,
                                            @Query(IConstants.PAGE_PARAM)        int page,
                                            @Query(IConstants.LAST_UPDATE_PARAM) long lastUpdate,
                                            @Query(IConstants.SIGN_PARAM)        String sign);
}
