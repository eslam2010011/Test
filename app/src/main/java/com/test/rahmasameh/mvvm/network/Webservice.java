package com.test.rahmasameh.mvvm.network;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class Webservice {


    @Provides
    @Singleton
    public RequestService provideWebservice() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create()).baseUrl("https://reqres.in/api/")
                .build().create(RequestService.class);

    }


}
