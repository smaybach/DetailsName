package com.example.details.model;
import com.example.details.model.entity.Home_entity;
import com.example.details.utils.RetrofitUtils;
import com.example.details.utils.RetrofitUtilss;
import com.example.details.utils.rootpath.Root_path;
import com.example.details.utils.service.APIService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

/**
 * Created by 家 on 2018/3/1.
 */

public class HomeModel implements IHomeModel {
    @Override
    public void show(final Home home) {
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
//        RetrofitUtils.getInstance().getHome()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Home_entity>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Home_entity value) {
//                        home.complateHome(value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//


        RetrofitUtilss.getInstance(Root_path.BASE_URL,ok)
                .setCreate(APIService.class)
                .getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Home_entity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Home_entity value) {
                        home.complateHome(value);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
