package com.example.rechee.smsmanage.dagger;

import com.example.rechee.smsmanage.repositories.interfaces.UserInfoRepository;
import com.example.rechee.smsmanage.viewModels.UserInfoViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rechee on 6/16/2017.
 */

@Module(includes = NetworkModule.class)
public class ViewModelModule {

    @Provides
    public UserInfoViewModel providesUserInfoViewModel(UserInfoRepository repository){
        return new UserInfoViewModel(repository);
    }
}
