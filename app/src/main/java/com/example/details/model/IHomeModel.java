package com.example.details.model;

import com.example.details.model.entity.Home_entity;

/**
 * Created by 家 on 2018/3/1.
 */

public interface IHomeModel {

    public void show(Home home);
    interface Home{
        void complateHome(Home_entity home_entity);
    }
}
