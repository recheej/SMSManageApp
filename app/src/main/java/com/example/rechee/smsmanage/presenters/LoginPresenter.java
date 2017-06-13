package com.example.rechee.smsmanage.presenters;

import com.example.rechee.smsmanage.http.ToggleServiceGenerator;
import com.example.rechee.smsmanage.http.interfaces.toggl.UserInfoService;
import com.example.rechee.smsmanage.models.TogglResponse;
import com.example.rechee.smsmanage.models.UserInfo;
import com.example.rechee.smsmanage.views.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rechee on 6/3/2017.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        super(view);
    }

    public void userEnteredLoginInformation(final String username, final String password){
        final String baseUrl = view.getBaseUrl();

        UserInfoService userInfoService = new ToggleServiceGenerator
                .Builder<>(UserInfoService.class, baseUrl)
                .username(username)
                .password(password)
                .build();

        Call<TogglResponse<UserInfo>> call = userInfoService.userInformation();

        call.enqueue(new Callback<TogglResponse<UserInfo>>() {
            @Override
            public void onResponse(Call<TogglResponse<UserInfo>> call, Response<TogglResponse<UserInfo>> response) {
                if(response.isSuccessful() && response.body() != null){
                    view.loginUser(response.body().data);
                }
            }

            @Override
            public void onFailure(Call<TogglResponse<UserInfo>> call, Throwable t) {
                //TODO: add error handling
            }
        });
    }
}
