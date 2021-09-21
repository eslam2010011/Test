package com.test.rahmasameh.mvvm_kotlin.network

import retrofit2.http.GET
import com.test.rahmasameh.mvvm_kotlin.model.PageDTO
import retrofit2.http.QueryMap
import java.util.HashMap

interface RequestService_kotlin {
    @GET("users")
    public suspend fun tPage(@QueryMap h: HashMap<String, String>): PageDTO
}