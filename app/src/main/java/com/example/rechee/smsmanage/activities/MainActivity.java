package com.example.rechee.smsmanage.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.rechee.smsmanage.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String preferenceFileKey = getString(R.string.preference_file_key);
        SharedPreferences sharedPref = this.getSharedPreferences(preferenceFileKey, Context.MODE_PRIVATE);
        String togglAuthToken = sharedPref.getString(getString(R.string.toggl_auth_token), "");
        if(togglAuthToken.isEmpty()){
            startActivity(new Intent(this, LoginActivity.class));
        }

        setContentView(R.layout.activity_main);
    }
}
