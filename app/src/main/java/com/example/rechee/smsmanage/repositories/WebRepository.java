package com.example.rechee.smsmanage.repositories;

import javax.inject.Inject;

/**
 * Created by Rechee on 6/11/2017.
 */

public class WebRepository {
    protected String baseUrl;

    @Inject
    public WebRepository(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public WebRepository() {}
}
