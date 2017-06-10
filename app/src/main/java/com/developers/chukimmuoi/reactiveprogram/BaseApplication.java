package com.developers.chukimmuoi.reactiveprogram;

import android.app.Application;

import com.developers.chukimmuoi.reactiveprogram.injection.components.DaggerNetComponent;
import com.developers.chukimmuoi.reactiveprogram.injection.components.DaggerSongComponent;
import com.developers.chukimmuoi.reactiveprogram.injection.components.NetComponent;
import com.developers.chukimmuoi.reactiveprogram.injection.components.SongComponent;
import com.developers.chukimmuoi.reactiveprogram.injection.modules.AppModule;
import com.developers.chukimmuoi.reactiveprogram.injection.modules.NetModule;
import com.developers.chukimmuoi.reactiveprogram.injection.modules.SongModule;

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

    private NetComponent mNetComponent;

    private SongComponent mSongComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(BASE_URL, false))
                .build();

        mSongComponent = DaggerSongComponent.builder()
                .netComponent(mNetComponent)
                .songModule(new SongModule())
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public SongComponent getSongComponent() {
        return mSongComponent;
    }
}
