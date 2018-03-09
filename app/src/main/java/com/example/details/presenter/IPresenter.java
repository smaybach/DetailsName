package com.example.details.presenter;

/**
 * Created by 家 on 2018/3/1.
 */

public interface IPresenter<T> {
    void attach(T view);
    void detach();
}
