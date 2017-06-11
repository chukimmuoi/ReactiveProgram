package com.developers.chukimmuoi.reactiveprogram;

import android.util.Log;

import com.developers.chukimmuoi.reactiveprogram.data.model.Result;
import com.developers.chukimmuoi.reactiveprogram.data.model.SongRequest;
import com.developers.chukimmuoi.reactiveprogram.data.online.service.ApiService;
import com.developers.chukimmuoi.reactiveprogram.ui.base.Presenter;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : ReactiveProgram
 * Created by chukimmuoi on 6/11/17.
 */

public class MainPresenter extends Presenter<MainView> {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private ApiService mApiService;

    private SongRequest mSongRequest;

    @Inject
    public MainPresenter(ApiService iApiService, SongRequest songRequest) {
        this.mApiService = iApiService;
        this.mSongRequest = songRequest;
    }

    public void useRetrofit(){
        getView().showLoading();

        Call<Result> callRetrofit = mApiService.listFromLastUpdate(mSongRequest.convertToMap());
        callRetrofit.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                //Code from 200 to 300.
                if (response.isSuccessful()) {
                    Log.e(TAG, "onResponse: " + response.body().toString());
                } else {
                    //Code result error.
                    int statusCode = response.code();
                    Log.e(TAG, "onResponse: statusCode = " + statusCode);
                }

                getView().hideLoading();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.e(TAG, "onFailure");

                getView().hideLoading();
            }
        });
    }

    public void useRxjava(){
        getView().showLoading();

        Observable<Result> callRxJava = mApiService.listFromLastUpdateRx(mSongRequest.convertToMap());
        callRxJava.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull Result result) {
                        Log.e(TAG, "onNext: result: " + result.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "onError");

                        getView().hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete");

                        getView().hideLoading();
                    }
                });
    }
}
