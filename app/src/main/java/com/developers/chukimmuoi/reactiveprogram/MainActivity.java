package com.developers.chukimmuoi.reactiveprogram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.developers.chukimmuoi.reactiveprogram.data.online.ApiServiceUtils;
import com.developers.chukimmuoi.reactiveprogram.object.Result;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Map<String, String> map = new HashMap<>();
                map.put("deviceId", "PX4KI5RC");
                map.put("number", String.valueOf(50));
                map.put("page", String.valueOf(1));
                map.put("lastUpdate", String.valueOf(1474390800000l));
                map.put("sign", "7ce0c550e8d4abfca675661f80a15b739dbca2fefc2fbc82d7cf0d8b1c3f1bf5");

                Call<Result> call = ApiServiceUtils.getSongApi().listFromLastUpdate(map);
                call.enqueue(new Callback<Result>() {
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
            case R.id.button1:
                Observable<Result> call1 = ApiServiceUtils.getSongApi().listFromLastUpdateRx();
                call1.subscribeOn(Schedulers.io())
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
