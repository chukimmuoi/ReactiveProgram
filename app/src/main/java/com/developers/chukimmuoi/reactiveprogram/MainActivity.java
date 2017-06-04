package com.developers.chukimmuoi.reactiveprogram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.developers.chukimmuoi.reactiveprogram.constants.IConstants;
import com.developers.chukimmuoi.reactiveprogram.data.online.ApiServiceUtils;
import com.developers.chukimmuoi.reactiveprogram.object.Result;

import java.util.HashMap;
import java.util.Map;

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
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements IConstants, View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Map<String, String> map;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getApplication()).getRetrofitClientComponent().inject(this);

        setContentView(R.layout.activity_main);

        map = new HashMap<>();
        map.put(DEVICE_ID_PARAM, DEVICE_ID_VALUES);
        map.put(NUMBER_PARAM, String.valueOf(NUMBER_3000_VALUES));
        map.put(PAGE_PARAM, String.valueOf(PAGE_VALUES));
        map.put(LAST_UPDATE_PARAM, String.valueOf(LAST_UPDATE_VALUES));
        map.put(SIGN_PARAM, SIGN_3000_VALUES);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //TODO: Retrofit
            case R.id.btn_retrofit:
                Call<Result> callRetrofit = ApiServiceUtils.getSongApi(retrofit).listFromLastUpdate(map);
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
                Observable<Result> callRxJava = ApiServiceUtils.getSongApi(retrofit).listFromLastUpdateRx(map);
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
