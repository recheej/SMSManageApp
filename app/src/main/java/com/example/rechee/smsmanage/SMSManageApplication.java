package com.example.rechee.smsmanage;

import android.app.Application;

import com.example.rechee.smsmanage.dagger.DaggerServiceComponent;
import com.example.rechee.smsmanage.dagger.NetworkModule_Factory;

/**
 * Created by Rechee on 6/11/2017.
 */

public class SMSManageApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerServiceComponent component = DaggerServiceComponent.builder()
                .networkModule()

    }
}
