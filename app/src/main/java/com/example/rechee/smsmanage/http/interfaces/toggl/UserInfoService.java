package com.example.rechee.smsmanage.http.interfaces.toggl;

import com.example.rechee.smsmanage.models.TogglResponse;
import com.example.rechee.smsmanage.models.UserInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rechee on 5/28/2017.
 */

public interface UserInfoService {
    @GET("me")
    Call<TogglResponse<UserInfoResponse>> userInformation();
}
