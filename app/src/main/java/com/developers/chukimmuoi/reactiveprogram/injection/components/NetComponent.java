package com.developers.chukimmuoi.reactiveprogram.injection.components;

import com.developers.chukimmuoi.reactiveprogram.injection.PerActivity;
import com.developers.chukimmuoi.reactiveprogram.injection.modules.AppModule;
import com.developers.chukimmuoi.reactiveprogram.injection.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : ReactiveProgram
 * Created by chukimmuoi on 5/30/17.
 */

@Singleton
@PerActivity
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit retrofit();

    OkHttpClient okHttpClient();
}
