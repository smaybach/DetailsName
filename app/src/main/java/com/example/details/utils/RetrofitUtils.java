package com.example.details.utils;

import com.example.details.utils.rootpath.Root_path;
import com.example.details.utils.service.APIService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mx丶 on 17/12/5.
 */

public class RetrofitUtils {
    private static APIService service  = null ;
    public static APIService getInstance(){
        if(service == null){
            synchronized (RetrofitUtils.class){

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Root_path.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
                service = retrofit.create(APIService.class);
            }
        }
        return service;
    }

}
