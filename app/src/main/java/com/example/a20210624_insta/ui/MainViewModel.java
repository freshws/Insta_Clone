package com.example.a20210624_insta.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.net.HttpCookie;
import java.util.Random;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> lvAvartarImgUrl = new MutableLiveData<>();


    public MainViewModel() {

        //생성자 안에 이미지 세팅 내용을 구현해둠으로서 화면을 가로세로 전환 하는등 view를 새로 그릴 때에도 그대로 남아 있음
        
        //아바타 이미지 세팅
        //랜덤으로 1 ~ 10 사이 숫자가 생성되도록 함
        String avatarImgUrl = "https://i.pravatar.cc/600?img=" + new Random().nextInt(10) + 1;
        lvAvartarImgUrl.setValue(avatarImgUrl);


    }
}
