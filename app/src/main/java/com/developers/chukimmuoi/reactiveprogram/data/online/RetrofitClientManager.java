package com.developers.chukimmuoi.reactiveprogram.data.online;

import com.developers.chukimmuoi.reactiveprogram.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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
 * Created by chukimmuoi on 5/7/17.
 */

public class RetrofitClientManager {

    // eg: Base URL: always ends with "/".
    private static final String BASE_URL = "http://api.hanet.com/karaoke/";

    private static final int VALUES_READ_TIMEOUT = 60;

    private static final int VALUES_CONNECT_TIMEOUT = 60;

    private static RetrofitClientManager ourInstance;

    private static Retrofit mRetrofit;

    private static OkHttpClient mClient;

    private static Gson mGson;

    public RetrofitClientManager() {

        mClient = interceptorHandler(false);

        mGson = gsonHandler();
    }

    public static Retrofit getClient() {
        if (mRetrofit == null) {
            synchronized (RetrofitClientManager.class) {
                if (ourInstance == null) {
                    ourInstance = new RetrofitClientManager();
                }

                mRetrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(mGson))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(mClient)
                        .build();
            }
        }

        return mRetrofit;
    }

    /**
     * Custom gson.
     * eg: gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
     */
    private Gson gsonHandler() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.create();
        return gson;
    }

    /**
     * @param isCallExactlyOnce true: use NetworkInterceptor (call 1 chain.proceed),
     *                          false: use Interceptor (call 1 or n chain.proceed).
     */
    private OkHttpClient interceptorHandler(boolean isCallExactlyOnce) {
        //TODO: Define the interceptor, add authentication headers.
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

        //TODO: Add the interceptor to OkHttpClient.
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (isCallExactlyOnce) {
            builder.addNetworkInterceptor(interceptor);
        } else {
            builder.addInterceptor(interceptor);
        }
        builder.readTimeout(VALUES_READ_TIMEOUT, TimeUnit.SECONDS);
        builder.connectTimeout(VALUES_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();

        return client;
    }

    /**
     * Add new parameter in header.
     * eg: chain.request().newBuilder().url(url).
     */
    private HttpUrl addQueryParameter(Interceptor.Chain chain) {
        HttpUrl url = chain.request().url().newBuilder()
                .addQueryParameter("", "")
                .build();

        return url;
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

    public void onDestroy() {
        if (mClient != null) {
            mClient = null;
        }
        if (mGson != null) {
            mGson = null;
        }
        if (mRetrofit != null) {
            mRetrofit = null;
        }
        if (ourInstance != null) {
            ourInstance = null;
        }
    }
}
