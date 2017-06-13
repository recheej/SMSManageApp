package com.example.rechee.smsmanage.dagger;

import com.example.rechee.smsmanage.repositories.WebRepository;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Rechee on 6/11/2017.
 */

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface ServiceComponent {
    void inject(WebRepository repository);
    Retrofit retrofit();
}
