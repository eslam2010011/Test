package com.test.rahmasameh.mvvm_kotlin.repository

import com.test.rahmasameh.mvvm_kotlin.model.PageDTO
import com.test.rahmasameh.mvvm_kotlin.network.RequestService_kotlin
import javax.inject.Inject
 import java.util.HashMap

class Repository_kotlin @Inject constructor(var requestService: RequestService_kotlin) {
    public suspend fun getUsers(hashMap: HashMap<String, String>): PageDTO {
        return requestService.tPage(hashMap)
    }
}