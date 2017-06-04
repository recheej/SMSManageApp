package com.example.rechee.smsmanage.views;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.rechee.smsmanage.R;

/**
 * Created by Rechee on 6/3/2017.
 */

public abstract class AbstractView extends Activity implements IView {
    @Override
    public String getApiToken() {
        String preferenceFileKey = getString(R.string.preference_file_key);
        SharedPreferences sharedPref = this.getSharedPreferences(preferenceFileKey, Context.MODE_PRIVATE);
        return sharedPref.getString(getString(R.string.toggl_api_token), "");
    }

    @Override
    public String getBaseUrl() {

        return getString(R.string.toggleAPIUrl);
    }
}
