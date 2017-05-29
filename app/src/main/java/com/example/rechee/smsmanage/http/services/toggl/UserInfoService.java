package com.example.rechee.smsmanage.http.services.toggl;

import com.example.rechee.smsmanage.http.models.toggl.UserInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rechee on 5/28/2017.
 */

public interface UserInfoService {
    @GET("me")
    Call<UserInfoResponse> userInformation();
}
