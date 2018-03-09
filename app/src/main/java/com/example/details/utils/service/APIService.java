package com.example.details.utils.service;

import com.example.details.model.entity.Home_entity;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 家 on 2018/3/1.
 */

public interface APIService {
    //https://www.zhaoapi.cn/ad/getAd
    @GET("ad/getAd")
    Observable<Home_entity> getHome();

}
