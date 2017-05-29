package com.example.rechee.smsmanage.http;

import com.example.rechee.smsmanage.http.models.toggl.TogglApiError;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

import com.example.rechee.smsmanage.http.ToggleServiceGenerator;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Created by Rechee on 5/29/2017.
 */

public class ErrorUtils {
    public static <T> TogglApiError parseError(Response<T> response, String baseUrl){

        Converter<ResponseBody, TogglApiError> converter =
                ToggleServiceGenerator.retrofit(baseUrl)
                        .responseBodyConverter(TogglApiError.class, new Annotation[0]);

        TogglApiError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new TogglApiError();
        }

        return error;
    }


}
