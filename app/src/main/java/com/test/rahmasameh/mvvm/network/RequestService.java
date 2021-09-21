package com.test.rahmasameh.mvvm.network;

import com.test.rahmasameh.mvvm.model.PageDTO;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

 public interface RequestService {


    @GET("users")
     public Call<PageDTO> tPage(@QueryMap()  HashMap<String, String> h);

 }
