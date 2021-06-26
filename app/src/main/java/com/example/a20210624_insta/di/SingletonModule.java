package com.example.a20210624_insta.di;

import com.example.a20210624_insta.service.MemberService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class SingletonModule {

    @Provides
    @Singleton
    public static MemberService provideMemberService() {
        
        //이런 값으로 Memberservice 객체를 넘겨주는데 힐트 적용으로 Memberservice 를 사용하는 곳에 리턴한 객체를 넘겨줌
        return new MemberService();
    }
}