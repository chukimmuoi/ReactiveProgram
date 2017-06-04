package com.developers.chukimmuoi.reactiveprogram;

import android.app.Application;

import com.developers.chukimmuoi.reactiveprogram.injection.components.DaggerRetrofitClientComponent;
import com.developers.chukimmuoi.reactiveprogram.injection.components.RetrofitClientComponent;
import com.developers.chukimmuoi.reactiveprogram.injection.modules.AppModule;
import com.developers.chukimmuoi.reactiveprogram.injection.modules.RetrofitClientModule;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : ReactiveProgram
 * Created by chukimmuoi on 5/30/17.
 */

public class BaseApplication extends Application {

    private static final String BASE_URL = "http://api.hanet.com/karaoke/";

    private RetrofitClientComponent mRetrofitClientComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofitClientComponent = DaggerRetrofitClientComponent.builder()
                .appModule(new AppModule(this))
                .retrofitClientModule(new RetrofitClientModule(BASE_URL, false))
                .build();
    }

    public RetrofitClientComponent getRetrofitClientComponent() {
        return mRetrofitClientComponent;
    }
}
