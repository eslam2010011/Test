package com.test.rahmasameh.mvvm.repository;

import com.test.rahmasameh.mvvm.model.PageDTO;
import com.test.rahmasameh.mvvm.network.RequestService;

import java.util.HashMap;

import javax.inject.Inject;

import retrofit2.Call;

public class Repository {
    RequestService requestService;

    @Inject
    public Repository(RequestService requestService) {
        this.requestService = requestService;
    }

    public Call<PageDTO> getUsers(HashMap<String,String> hashMap){
         return requestService.tPage(hashMap);
    }
}
