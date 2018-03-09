package com.example.details.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.details.R;

/**
 * Created by 家 on 2018/3/2.
 */

public class plusview extends LinearLayout {
    Button revserse,tianjian;
    EditText edittext;
    private  int mcount = 1;//定义一个常量 用于购物车就入时默认显示为1


    public plusview(Context context) {
        super(context);
    }

    public plusview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //加载布局
        View view= View.inflate(context, R.layout.plus_layout,null);
        //初始化控件
        revserse=view.findViewById(R.id.revserse);//减号
        tianjian=view.findViewById(R.id.tianjian);//加号
        edittext=view.findViewById(R.id.edittext);//加减号中间的输入框
//设置控件 的点击事件
        //减号的点击事件
        revserse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String trims=edittext.getText().toString().trim();//获取输入框的值
                int coun=Integer.valueOf(trims);//将从输入框得到的值换成整形
                    if (coun>1){
                        mcount=coun-1;
                        edittext.setText(mcount+"");
                        if (listener!=null){
                            listener.click(mcount);
                        }
                    }
            }
        });
        //加号的点击事件
        tianjian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim=edittext.getText().toString().trim();//获取输入框的值并去掉空格
                int coun=Integer.valueOf(trim)+1;
                mcount=coun;
                edittext.setText(coun+"");
                if (listener!=null){
                    listener.click(coun);
                }

            }
        });
        //输入框的点击事件
        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        addView(view);
    }
    public plusview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setEditText(int num){
        if (edittext!=null){
            edittext.setText(num);
        }
    }
    public ClickListener listener;
    public void setListener(ClickListener listener ){
        this.listener=listener;
    }
    /**
     * 加减号的点击事件
     */
    public  interface  ClickListener{
        public void click(int coun);
    }

}
