package com.example.myapplication.base;

import android.app.Application;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class Baseactivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
        initListtener();
    }

    protected abstract void initListtener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();

}
