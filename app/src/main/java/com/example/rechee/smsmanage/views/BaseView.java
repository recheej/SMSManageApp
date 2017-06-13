package com.example.rechee.smsmanage.views;

import android.support.v7.widget.Toolbar;

import com.example.rechee.smsmanage.presenters.BasePresenter;

/**
 * Created by Rechee on 6/3/2017.
 */

public interface BaseView {
    String getApiToken();
    String getBaseUrl();
    Toolbar getToolBar();
}
