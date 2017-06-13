package com.example.rechee.smsmanage.dagger;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.rechee.smsmanage.http.TogglAuthenticationInterceptor;
import com.example.rechee.smsmanage.http.ToggleServiceGenerator;
import com.example.rechee.smsmanage.http.interfaces.toggl.RetroFitService;
import com.example.rechee.smsmanage.http.interfaces.toggl.TimeEntryService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rechee on 6/11/2017.
 */

@Module
public class NetworkModule {

    private String baseUrl;
    private String apiToken;

    @Inject
    public NetworkModule(String baseUrl, String apiToken){
    }

    @Singleton
    @Provides
    public Gson providesGson() {
        return new GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Singleton
    @Provides
    public Retrofit providesRetrofit(Gson gson, OkHttpClient client){

        Retrofit.Builder retrofitBuilder =
                new Retrofit.Builder()
                        .baseUrl(this.baseUrl)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(gson));

        return retrofitBuilder.build();
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(TogglAuthenticationInterceptor interceptor){
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);

        return client.build();
    }

    @Singleton
    @Provides
    public TogglAuthenticationInterceptor provideTogglAuthenticationInterceptor() {
        return new TogglAuthenticationInterceptor(this.apiToken);
    }
}
