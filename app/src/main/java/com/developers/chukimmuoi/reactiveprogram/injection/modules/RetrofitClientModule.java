package com.developers.chukimmuoi.reactiveprogram.injection.modules;

import android.app.Application;

import com.developers.chukimmuoi.reactiveprogram.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : ReactiveProgram
 * Created by chukimmuoi on 5/30/17.
 */

@Module
public class RetrofitClientModule {

    private static final int VALUES_READ_TIMEOUT = 60;

    private static final int VALUES_CONNECT_TIMEOUT = 60;

    String mBaseUrl;

    boolean isCallExactlyOnce;

    /**
     * @param isCallExactlyOnce true: use NetworkInterceptor (call 1 chain.proceed),
     *                          false: use Interceptor (call 1 or n chain.proceed).
     */
    public RetrofitClientModule(String baseUrl, boolean isCallExactlyOnce) {
        this.mBaseUrl = baseUrl;
        this.isCallExactlyOnce = isCallExactlyOnce;
    }

    /**
     * Custom gson.
     * eg: gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
     */
    @Singleton
    @Provides
    Gson providesGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.create();
        return gson;
    }

    @Singleton
    @Provides
    Interceptor providesInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request().newBuilder()
                        .addHeader("Cache-Control", "max-age=640000")
                        .addHeader("User-Agent", "Reactive Program")
                        .build();

                Response response = chain.proceed(request);

                if (BuildConfig.DEBUG) {
                    showInformationService(chain, request, response);
                }

                return response;
            }
        };

        return interceptor;
    }

    private void showInformationService(Interceptor.Chain chain, Request request,
                                        Response response) {
        Logger logger = Logger.getLogger("INFORMATION");
        long timeStart = System.nanoTime();
        logger.info(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));

        long timeEnd = System.nanoTime();
        logger.info(String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (timeEnd - timeStart) / 1e6d, response.headers()));
    }

    @Singleton
    @Provides
    Cache providesOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Singleton
    @Provides
    OkHttpClient providesOkHttpClient(Interceptor interceptor, Cache cache) {
        //TODO: Add the interceptor to OkHttpClient.
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (isCallExactlyOnce) {
            builder.addNetworkInterceptor(interceptor);
        } else {
            builder.addInterceptor(interceptor);
        }
        builder.readTimeout(VALUES_READ_TIMEOUT, TimeUnit.SECONDS);
        builder.connectTimeout(VALUES_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.cache(cache);
        OkHttpClient client = builder.build();

        return client;
    }

    /**
     * Add new parameter in header.
     * eg: chain.request().newBuilder().url(url).
     */
    @Singleton
    @Provides
    HttpUrl providesHttpUrl(Interceptor.Chain chain) {
        HttpUrl url = chain.request().url().newBuilder()
                .addQueryParameter("", "")
                .build();

        return url;
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit(Gson gson, OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}
