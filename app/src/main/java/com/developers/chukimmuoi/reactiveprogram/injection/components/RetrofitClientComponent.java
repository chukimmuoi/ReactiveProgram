package com.developers.chukimmuoi.reactiveprogram.injection.components;

import com.developers.chukimmuoi.reactiveprogram.MainActivity;
import com.developers.chukimmuoi.reactiveprogram.injection.modules.AppModule;
import com.developers.chukimmuoi.reactiveprogram.injection.modules.RetrofitClientModule;

import javax.inject.Singleton;

import dagger.Component;

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
@Component(modules = {AppModule.class, RetrofitClientModule.class})
public interface RetrofitClientComponent {
    void inject(MainActivity activity);
}
