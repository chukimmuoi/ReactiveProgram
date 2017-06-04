package com.developers.chukimmuoi.reactiveprogram.data.online;

import com.developers.chukimmuoi.reactiveprogram.data.online.service.IApiService;

import retrofit2.Retrofit;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : ReactiveProgram
 * Created by chukimmuoi on 5/7/17.
 */

public class ApiServiceUtils {

    public static IApiService getSongApi(Retrofit retrofit) {
        return retrofit.create(IApiService.class);
    }
}
