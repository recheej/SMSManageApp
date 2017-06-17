package com.example.rechee.smsmanage.dagger;

import com.example.rechee.smsmanage.models.UserInfo;
import com.example.rechee.smsmanage.repositories.UserInfoRepositoryWeb;
import com.example.rechee.smsmanage.repositories.WebRepository;
import com.example.rechee.smsmanage.repositories.interfaces.UserInfoRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Rechee on 6/16/2017.
 */

@Module(includes = NetworkModule.class)
public class WebRepositoryModule {
    @Provides
    public WebRepository provideWebRepository(Retrofit retrofit){
        return new WebRepository(retrofit);
    }

    @Provides
    public UserInfoRepository provideUserInfoWebRepository(Retrofit retrofit){
        return new UserInfoRepositoryWeb(retrofit);
    }
}
