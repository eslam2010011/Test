package com.test.rahmasameh.pure.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResteasyClient {

    static Retrofit retrofit;
    public static ResteasyClient resteasyClient;
    RequestService api;

    public static ResteasyClient getInstance() {
        if (resteasyClient == null) {
            resteasyClient = new ResteasyClient();
            return resteasyClient;
        }
        return resteasyClient;
    }

    public ResteasyClient() {
        retrofit = new Retrofit.Builder().baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(RequestService.class);

    }

    public RequestService getAppService() {
        if (api != null) {
            return api;
        }
        return null;
    }


}
