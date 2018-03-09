package com.example.details.presenter;

import com.example.details.model.entity.Home_entity;
import com.example.details.model.HomeModel;
import com.example.details.model.IHomeModel;
import com.example.details.view.Interface.HomeView;

import java.lang.ref.WeakReference;

/**
 * Created by 家 on 2018/3/1.
 */

public class HomePresenter implements IPresenter<HomeView> {
    IHomeModel model;
    private WeakReference<HomeView> weakReference;

    public HomePresenter(HomeView view){
        attach(view);
        model=new HomeModel();

    }

    @Override
    public void attach(HomeView view) {
        weakReference = new WeakReference<>(view);
    }

    @Override
    public void detach() {
        weakReference.clear();
    }
    public void showHome(){
        model.show(new IHomeModel.Home() {
            @Override
            public void complateHome(Home_entity home_entity) {
                weakReference.get().homeView(home_entity);
            }
        });
    }
}
