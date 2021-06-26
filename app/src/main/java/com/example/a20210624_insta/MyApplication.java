package com.example.a20210624_insta;

import android.app.Application;

import com.example.a20210624_insta.Util.Util;

import dagger.hilt.android.HiltAndroidApp;

//힐트 적용을 위해 삽입
@HiltAndroidApp
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Util.init(this);
    }
}

