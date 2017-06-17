package com.example.rechee.smsmanage.dagger;

import android.support.v7.app.AppCompatActivity;

import com.example.rechee.smsmanage.activities.MainActivity;
import com.example.rechee.smsmanage.repositories.WebRepository;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Rechee on 6/11/2017.
 */

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class, ViewModelModule.class, WebRepositoryModule.class})
public interface ServiceComponent {
    void inject(MainActivity activity);
    Retrofit retrofit();
}
