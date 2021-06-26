package com.example.a20210624_insta.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20210624_insta.service.MemberService;

import java.net.HttpCookie;
import java.util.Random;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

//힐트 적용을 위해 삽입
@HiltViewModel
public class MainViewModel extends ViewModel {
    public MutableLiveData<String> lvAvartarImgUrl = new MutableLiveData<>();


    //힐트 적용을 위해 삽입
    //힐트 적용으로 Application과 memberservice 매개변수는 알아서 넘겨준다
    @Inject
    public MainViewModel(@NonNull Application application, MemberService memberService) {
        //생성자 안에 이미지 세팅 내용을 구현해둠으로서 화면을 가로세로 전환 하는등 view를 새로 그릴 때에도 그대로 남아 있음
        
        //아바타 이미지 세팅
        //랜덤으로 1 ~ 10 사이 숫자가 생성되도록 함
        String avatarImgUrl = "https://i.pravatar.cc/600?img=" + new Random().nextInt(10) + 1;
        lvAvartarImgUrl.setValue(avatarImgUrl);

        //힐트 적용으로 알아서 memberservice 매개변수로 Memberservice 객체를 넘겨 주기 때문에
        //별도로 new Memberservice 로 객체를 생성해주지 않아도됨
        memberService.helloToast();

    }
}
