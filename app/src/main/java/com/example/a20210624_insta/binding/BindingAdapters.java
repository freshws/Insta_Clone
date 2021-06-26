package com.example.a20210624_insta.binding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.a20210624_insta.Util.Util;

public class BindingAdapters {

    //nav_header_main.xml의 <ImageView> 의 "app:"이 imgUrl 만 있으면 아래 메소드가 실행
    //매소드 Overload 처럼 기능하며 어노테이션의 이름이 중요함
    @BindingAdapter({"imgUrl"})
    public static void imgUrl(ImageView view, String imgUrl) {
        Util.loadImageOn(imgUrl, view);
    }

    //nav_header_main.xml의 <ImageView> 의 "app:"이 imgUrl와 borderRadius가 있으면 아래 메소드가 실행
    //매소드 Overload 처럼 기능하며 어노테이션의 이름이 중요함
    @BindingAdapter({"imgUrl", "borderRadius"})
    public static void borderRadius(ImageView view, String imgUrl, int borderRadius) {
        Util.loadImageOn(imgUrl, view, borderRadius);
    }

}
