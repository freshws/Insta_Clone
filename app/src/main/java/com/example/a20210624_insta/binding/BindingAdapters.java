package com.example.a20210624_insta.binding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.a20210624_insta.Util.Util;

public class BindingAdapters {

    @BindingAdapter({"imgUrl"})
    public static void imgUrl(ImageView view, String imgUrl) {
        Util.loadImageOn(imgUrl, view);
    }

}
