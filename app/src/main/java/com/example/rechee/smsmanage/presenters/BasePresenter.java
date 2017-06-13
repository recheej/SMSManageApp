package com.example.rechee.smsmanage.presenters;

import com.example.rechee.smsmanage.views.BaseView;

/**
 * Created by Rechee on 6/11/2017.
 */

public class BasePresenter<T> {
    T view;
    BasePresenter(T view){
        this.view = view;
    }
}
