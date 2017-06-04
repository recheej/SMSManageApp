package com.example.rechee.smsmanage.views;

import com.example.rechee.smsmanage.models.UserInfo;

/**
 * Created by Rechee on 6/3/2017.
 */

public interface ILoginView extends IView {
    void loginUser(UserInfo userInfo);
}
