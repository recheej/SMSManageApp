package com.example.rechee.smsmanage.views;

import com.example.rechee.smsmanage.models.UserInfo;
import com.example.rechee.smsmanage.presenters.MainPresenter;

/**
 * Created by Rechee on 6/3/2017.
 */

public interface LoginView extends BaseView {
    void loginUser(UserInfo userInfo);
}
