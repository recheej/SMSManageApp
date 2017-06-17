package com.example.rechee.smsmanage;

import android.app.Application;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.rechee.smsmanage.dagger.ContextModule;
import com.example.rechee.smsmanage.dagger.DaggerServiceComponent;
import com.example.rechee.smsmanage.dagger.NetworkModule;
import com.example.rechee.smsmanage.dagger.ViewModelModule;


/**
 * Created by Rechee on 6/11/2017.
 */

public class SMSManageApplication extends Application {

    private DaggerServiceComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        String preferenceFileKey = getString(R.string.preference_file_key);
        SharedPreferences sharedPref = this.getSharedPreferences(preferenceFileKey, Context.MODE_PRIVATE);
        String togglApiToken = sharedPref.getString(getString(R.string.toggl_api_token), "");


        this.component = (DaggerServiceComponent) DaggerServiceComponent.builder()
                .contextModule(new ContextModule(this))
                .networkModule(new NetworkModule(getString(R.string.toggleAPIUrl), togglApiToken))
                .viewModelModule(new ViewModelModule())
                .build();
    }

    public DaggerServiceComponent getComponent() {
        return this.component;
    }
}
