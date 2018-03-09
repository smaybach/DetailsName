package com.example.details.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.details.R;
import com.example.details.model.adapter.HomeAdapter;
import com.example.details.model.entity.Home_entity;
import com.example.details.presenter.HomePresenter;
import com.example.details.utils.base.BaseFragMent;
import com.example.details.view.Interface.HomeView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 家 on 2018/3/1.
 */
public class FragMent_Home extends BaseFragMent<HomePresenter> implements HomeView {

    @Bind(R.id.rcv_Home)
    RecyclerView rcvHome;
    HomePresenter homePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        homePresenter.showHome();
        return view;
    }

    @Override
    public void homeView(Home_entity home_entity) {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        rcvHome.setLayoutManager(manager);
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), home_entity);
        rcvHome.setAdapter(homeAdapter);
    }
    @Override
    protected void complatePresenterFragMent() {
        homePresenter = new HomePresenter(this);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
