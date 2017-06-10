package com.developers.chukimmuoi.reactiveprogram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.developers.chukimmuoi.reactiveprogram.constants.IConstants;
import com.developers.chukimmuoi.reactiveprogram.data.model.Result;
import com.developers.chukimmuoi.reactiveprogram.data.model.SongRequest;
import com.developers.chukimmuoi.reactiveprogram.data.online.service.IApiService;

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

public class MainActivity extends AppCompatActivity implements IConstants, View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    IApiService iApiService;

    @Inject
    SongRequest songRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getApplication()).getSongComponent().inject(this);

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //TODO: Retrofit
            case R.id.btn_retrofit:
                Call<Result> callRetrofit = iApiService.listFromLastUpdate(songRequest.convertToMap());
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
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        Log.e(TAG, "onFailure");
                    }
                });
                break;
            //TODO: RxJava, RxAndroid.
            case R.id.btn_rxjava:
                Observable<Result> callRxJava = iApiService.listFromLastUpdateRx(songRequest.convertToMap());
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
                            }

                            @Override
                            public void onComplete() {
                                Log.e(TAG, "onComplete");
                            }
                        });
                break;
        }
    }
}
