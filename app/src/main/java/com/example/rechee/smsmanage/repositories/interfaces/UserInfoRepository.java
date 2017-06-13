package com.example.rechee.smsmanage.repositories.interfaces;

import com.example.rechee.smsmanage.models.UserInfo;

/**
 * Created by Rechee on 6/11/2017.
 */

public interface UserInfoRepository {
    public UserInfo getUserInfo(String username, String password);
}
