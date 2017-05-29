package com.example.rechee.smsmanage.http;

import android.text.TextUtils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToggleServiceGenerator {

    public static class Builder<S, T> {
        //builder pattern to easily create a Service Generator
        private final String BASE_URL;

        //the service class that will be making http call
        private final Class<S> serviceClass;
        //the class of the response object that will be deserialized
        private Class<T> responseClass;
        private String username = "";
        private String password = "";
        private String authToken = "";

        public Builder(Class<S> serviceClass, Class<T> responseClass, String baseUrl){
            this.serviceClass = serviceClass;
            this.responseClass = responseClass;
            this.BASE_URL = baseUrl;
        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder authToken(String authToken){
            this.authToken = authToken;
            return this;
        }

        public S build() {
            return ToggleServiceGenerator.createService(this);
        }
    }

    public static Retrofit retrofit(String baseUrl){
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit.Builder retrofitBuilder =
                new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create(gson));

        return retrofitBuilder.build();
    }

    private static <S, T> S createService(Builder<S, T> builder){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                //register serializer that skips "data" top level json element
                .registerTypeAdapter(builder.responseClass, new ToggleResponseSerializer<T>())
                .create();

        Retrofit.Builder retrofitBuilder =
                new Retrofit.Builder()
                        .baseUrl(builder.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson));

        Retrofit retrofit = retrofit(builder.BASE_URL);

        OkHttpClient.Builder httpClient =
                new OkHttpClient.Builder();

        if(!TextUtils.isEmpty(builder.username)){
            if(TextUtils.isEmpty(builder.password)){
                //if the username is blank, let's assume that it is the api_token. according to Toggl, password is 'api_token'
                builder.password = "api_token";
            }

            String authToken = Credentials.basic(builder.username, builder.password);
            return getServiceFromToken(builder, retrofitBuilder, httpClient, authToken);
        }

        if(!TextUtils.isEmpty(builder.authToken)){
            builder.username = builder.authToken;
            builder.password = "api_token";
            return getServiceFromToken(builder, retrofitBuilder, httpClient, builder.authToken);
        }

        return retrofit.create(builder.serviceClass);
    }

    private static <S, T> S getServiceFromToken(Builder<S, T> builder, Retrofit.Builder retrofitBuilder, OkHttpClient.Builder httpClient, String authToken) {
        Retrofit retrofit;

        TogglAuthenticationInterceptor interceptor =
                new TogglAuthenticationInterceptor(authToken);

        if (!httpClient.interceptors().contains(interceptor)) {
            httpClient.addInterceptor(interceptor);
        }

        retrofitBuilder.client(httpClient.build());
        retrofit = retrofitBuilder.build();
        return retrofit.create(builder.serviceClass);
    }
}
