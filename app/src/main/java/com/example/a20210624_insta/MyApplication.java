package com.example.a20210624_insta;

import android.app.Application;

import com.example.a20210624_insta.Util.Util;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Util.init(this);
    }
}

