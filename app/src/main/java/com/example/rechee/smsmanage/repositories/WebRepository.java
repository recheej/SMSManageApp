package com.example.rechee.smsmanage.repositories;

import android.webkit.WebResourceError;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by Rechee on 6/11/2017.
 */

public class WebRepository {

    @Inject
    Retrofit retrofit;

    @Inject
    public WebRepository(Retrofit retrofit){
    }
}
