package com.example.details.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 家 on 2018/3/1.
 */

public class RetrofitUtilss {
    private Retrofit mRetrofit;
    private String baseUrl;
    OkHttpClient client;
    private static RetrofitUtilss mRetrofitManager;
    private RetrofitUtilss(String baseUrl, OkHttpClient client){
        this.baseUrl=baseUrl;
        this.client=client;
        initRetrofit();
    }
    public static synchronized RetrofitUtilss getInstance(String baseUrl, OkHttpClient client){
        if (mRetrofitManager == null){
            mRetrofitManager = new RetrofitUtilss(baseUrl,client);
        }
        return mRetrofitManager;
    }
    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }
    public <T> T setCreate(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }
}
