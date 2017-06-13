package com.example.rechee.smsmanage.repositories;

import com.example.rechee.smsmanage.http.interfaces.toggl.UserInfoService;
import com.example.rechee.smsmanage.models.UserInfo;
import com.example.rechee.smsmanage.repositories.interfaces.UserInfoRepository;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by Rechee on 6/11/2017.
 */

public class UserInfoRepositoryWeb extends WebRepository implements UserInfoRepository {

    @Inject
    public UserInfoRepositoryWeb(Retrofit retrofit){
        super(retrofit);
    }

    @Override
    public UserInfo getUserInfo(String username, String password) {
        UserInfoService userInfoService = retrofit.create(UserInfoService.class);

        return new UserInfo();
    }
}
