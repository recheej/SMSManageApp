package com.example.rechee.smsmanage;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.rechee.smsmanage.dagger.DaggerServiceComponent;
import com.example.rechee.smsmanage.dagger.NetworkModule;

import javax.inject.Named;

import dagger.Provides;

/**
 * Created by Rechee on 6/11/2017.
 */

public class SMSManageApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        String baseUrl = providesBaseurl();
        String apiToken = providesToken();

        DaggerServiceComponent component = (DaggerServiceComponent) DaggerServiceComponent.builder()
                .networkModule(new NetworkModule(baseUrl, apiToken))
                .build();
    }


    public String providesBaseurl() {
        return this.getResources().getString(R.string.toggleAPIUrl);
    }

    public String providesToken() {
        String preferenceFileKey = this.getString(R.string.preference_file_key);
        SharedPreferences sharedPref = this.getSharedPreferences(preferenceFileKey, Context.MODE_PRIVATE);
        return sharedPref.getString(this.getString(R.string.toggl_api_token), "");
    }
}
