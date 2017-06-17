package com.example.rechee.smsmanage.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.rechee.smsmanage.http.interfaces.toggl.UserInfoService;
import com.example.rechee.smsmanage.models.UserInfo;
import com.example.rechee.smsmanage.repositories.interfaces.UserInfoRepository;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by Rechee on 6/11/2017.
 */

public class UserInfoViewModel extends ViewModel {
    private final UserInfoService userInfoService;
    private MutableLiveData<UserInfo> userInfo;
    @Inject Retrofit retrofit;

    @Inject
    public UserInfoViewModel(UserInfoRepository){
        this.userInfoService = retrofit.create(UserInfoService.class);
    }

    public LiveData<UserInfo> getUserInfo(String username, String password){
        this.userInfo =  new MutableLiveData<UserInfo>();
        this.userInfo.setValue(new UserInfo());
        return this.userInfo;
    }
}
