package com.example.rechee.smsmanage.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.rechee.smsmanage.models.UserInfo;
import com.example.rechee.smsmanage.repositories.interfaces.UserInfoRepository;

import javax.inject.Inject;

/**
 * Created by Rechee on 6/11/2017.
 */

public class UserInfoViewModel extends ViewModel {
    @Inject public UserInfoRepository repository;
    //private MutableLiveData<UserInfo> userInfo;

    @Inject
    public UserInfoViewModel(UserInfoRepository repository){
        this.repository = repository;
    }

    public UserInfo getUserInfo(String username, String password){
        return this.repository.getUserInfo(username, password);
    }
}
