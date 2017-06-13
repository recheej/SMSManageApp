package com.example.rechee.smsmanage.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.rechee.smsmanage.R;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rechee on 6/11/2017.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    public Context providesContext() {
        return context;
    }

    @Provides
    @Named("baseUrl")
    public String providesBaseurl() {
        return context.getResources().getString(R.string.toggleAPIUrl);
    }

    @Provides
    @Named("apiToken")
    public String providesToken() {
        String preferenceFileKey = context.getString(R.string.preference_file_key);
        SharedPreferences sharedPref = context.getSharedPreferences(preferenceFileKey, Context.MODE_PRIVATE);
        return sharedPref.getString(context.getString(R.string.toggl_api_token), "");
    }


}
