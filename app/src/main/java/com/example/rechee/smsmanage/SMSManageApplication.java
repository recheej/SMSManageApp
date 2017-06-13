package com.example.rechee.smsmanage;

import android.app.Application;

import com.example.rechee.smsmanage.dagger.ContextModule;
import com.example.rechee.smsmanage.dagger.DaggerServiceComponent;
import com.example.rechee.smsmanage.dagger.ServiceComponent;
import com.example.rechee.smsmanage.dagger.ServiceModule;

/**
 * Created by Rechee on 6/11/2017.
 */

public class SMSManageApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ServiceComponent component = DaggerServiceComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }
}
