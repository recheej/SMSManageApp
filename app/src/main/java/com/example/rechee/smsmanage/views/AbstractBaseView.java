package com.example.rechee.smsmanage.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.rechee.smsmanage.R;
import com.example.rechee.smsmanage.presenters.BasePresenter;

/**
 * Created by Rechee on 6/3/2017.
 */

public abstract class AbstractBaseView<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected T presenter;
    public AbstractBaseView(T presenter){
        this.presenter = presenter;
    }

    public AbstractBaseView() {}

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

    @Override
    public Toolbar getToolBar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }
}