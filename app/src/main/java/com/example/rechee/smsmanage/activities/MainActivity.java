package com.example.rechee.smsmanage.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.rechee.smsmanage.R;
import com.example.rechee.smsmanage.presenters.MainPresenter;
import com.example.rechee.smsmanage.views.AbstractView;
import com.example.rechee.smsmanage.views.IMainView;

public class MainActivity extends AbstractView implements IMainView {

    private MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String preferenceFileKey = getString(R.string.preference_file_key);
        SharedPreferences sharedPref = this.getSharedPreferences(preferenceFileKey, Context.MODE_PRIVATE);
        String togglApiToken = sharedPref.getString(getString(R.string.toggl_api_token), "");
        if(togglApiToken.isEmpty()){
            startActivity(new Intent(this, LoginActivity.class));
        }

        mainPresenter = new MainPresenter(this);
        mainPresenter.getTimeEntriesFromLastDay();

        setContentView(R.layout.activity_main);
    }
}
