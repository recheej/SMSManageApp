package com.example.rechee.smsmanage.dagger;

import com.example.rechee.smsmanage.repositories.UserInfoRepositoryWeb;
import com.example.rechee.smsmanage.repositories.WebRepository;
import com.example.rechee.smsmanage.repositories.interfaces.UserInfoRepository;

import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Rechee on 6/13/2017.
 */

public class ViewModelModule {

    @Provides
    public UserInfoRepository provideWebRepository(Retrofit retrofit) {
        return new UserInfoRepositoryWeb(retrofit);
    }
}
