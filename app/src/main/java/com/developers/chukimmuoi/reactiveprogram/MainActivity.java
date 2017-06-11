package com.developers.chukimmuoi.reactiveprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.developers.chukimmuoi.reactiveprogram.constants.IConstants;
import com.developers.chukimmuoi.reactiveprogram.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements IConstants, View.OnClickListener, MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getApplication()).getSongComponent().inject(this);

        setContentView(R.layout.activity_main);

        mMainPresenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //TODO: Retrofit
            case R.id.btn_retrofit:
                mMainPresenter.useRetrofit();
                break;
            //TODO: RxJava, RxAndroid.
            case R.id.btn_rxjava:
                mMainPresenter.useRxjava();
                break;
        }
    }

    @Override
    public void showLoading() {
        Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(MainActivity.this, "Ending", Toast.LENGTH_LONG).show();
    }
}
