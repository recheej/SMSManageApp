package com.example.rechee.smsmanage.repositories;

import com.example.rechee.smsmanage.http.interfaces.toggl.UserInfoService;
import com.example.rechee.smsmanage.models.UserInfo;
import com.example.rechee.smsmanage.repositories.interfaces.UserInfoRepository;

/**
 * Created by Rechee on 6/11/2017.
 */

public class UserInfoRepositoryWeb implements UserInfoRepository {

    private final UserInfoService userInfoService;

    public UserInfoRepositoryWeb(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public UserInfo getUserInfo(String username, String password) {
        return null;
    }
}
