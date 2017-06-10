package com.developers.chukimmuoi.reactiveprogram.injection.modules;

import com.developers.chukimmuoi.reactiveprogram.data.online.service.IApiService;
import com.developers.chukimmuoi.reactiveprogram.injection.UserScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : ReactiveProgram
 * Created by chukimmuoi on 6/4/17.
 */

@Module
public class SongModule {
    @Provides
    @UserScope
    public IApiService providesSong(Retrofit retrofit){
        return retrofit.create(IApiService.class);
    }
}
