package com.test.rahmasameh.mvvm_kotlin.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.rahmasameh.mvvm_kotlin.model.UserDTO
import com.test.rahmasameh.mvvm_kotlin.repository.Repository_kotlin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

@HiltViewModel
class UsersViewModel_kotlin @Inject constructor(var repository: Repository_kotlin) : ViewModel() {
    var users = MutableLiveData<List<UserDTO>>()
    fun getUserList(page: Int) {
        val hashMap = HashMap<String, String>()
        hashMap["page"] = page.toString()
        viewModelScope.launch {
            var response = repository.getUsers(hashMap);
            users.value = response.data
        }

    }
}