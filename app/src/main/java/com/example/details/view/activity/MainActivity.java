package com.example.details.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.details.R;
import com.example.details.view.fragment.FragMent_Home;
import com.example.details.view.fragment.FragMent_Shop;
import com.example.details.view.fragment.FragMent_find;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.bottom)
    BottomTabBar bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottom.init(getSupportFragmentManager())
                .setImgSize(80,80)
                .setChangeColor(Color.RED,Color.BLACK)
                .setFontSize(0)
                .setTabPadding(0,0,0)
                .addTabItem("",R.drawable.ac0, FragMent_Home.class)
                .addTabItem("",R.drawable.abu, FragMent_Shop.class)
                .addTabItem("",R.drawable.aby, FragMent_find.class)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                    }
                });
    }
}