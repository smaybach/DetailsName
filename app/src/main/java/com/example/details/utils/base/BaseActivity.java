package com.example.details.utils.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.details.presenter.IPresenter;
/**
 * Created by 家 on 2018/3/1.
 */
public abstract class BaseActivity<T extends IPresenter> extends Activity {
    T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        complatePresenter();
    }
    protected abstract void complatePresenter();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter==null){
            presenter.detach();
        }
    }
}
