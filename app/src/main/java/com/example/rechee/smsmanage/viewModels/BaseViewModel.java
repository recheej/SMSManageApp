package com.example.rechee.smsmanage.viewModels;

import android.arch.lifecycle.ViewModel;

import com.example.rechee.smsmanage.repositories.WebRepository;

import retrofit2.Retrofit;

/**
 * Created by Rechee on 6/13/2017.
 */

public class BaseViewModel extends ViewModel {
    public BaseViewModel(WebRepository repository){

    }
}
