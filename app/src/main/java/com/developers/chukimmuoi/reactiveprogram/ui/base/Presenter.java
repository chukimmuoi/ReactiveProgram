package com.developers.chukimmuoi.reactiveprogram.ui.base;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : ReactiveProgram
 * Created by chukimmuoi on 6/11/17.
 */

public class Presenter<T extends BaseView> implements BasePresenter<T> {

    private T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    public T getView() {
        return view;
    }

    public boolean isAttachView() {
        return view != null;
    }

    public void checkViewAttached() {
        if (!isAttachView()) throw new ViewNotAttachException();
    }
}
