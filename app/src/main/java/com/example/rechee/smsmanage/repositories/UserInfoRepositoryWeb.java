package com.example.rechee.smsmanage.repositories;

import com.example.rechee.smsmanage.http.interfaces.toggl.UserInfoService;
import com.example.rechee.smsmanage.models.TogglResponse;
import com.example.rechee.smsmanage.models.UserInfo;
import com.example.rechee.smsmanage.repositories.interfaces.UserInfoRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
        return userInfoService.userInformation().enqueue(new Callback<TogglResponse<UserInfo>>() {
            @Override
            public void onResponse(Call<TogglResponse<UserInfo>> call, Response<TogglResponse<UserInfo>> response) {

            }

            @Override
            public void onFailure(Call<TogglResponse<UserInfo>> call, Throwable t) {

            }
        });
        return new UserInfo();
    }
}
