package com.example.details.utils.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.details.presenter.IPresenter;

/**
 * Created by 家 on 2018/3/1.
 */

public abstract class BaseFragMent<T extends IPresenter> extends Fragment {
    T Presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        complatePresenterFragMent();
    }
    protected abstract void complatePresenterFragMent();
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (Presenter==null){
            Presenter.detach();
        }
    }
}
