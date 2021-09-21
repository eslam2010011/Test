package com.test.rahmasameh.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.test.rahmasameh.mvvm.model.PageDTO;
import com.test.rahmasameh.mvvm.model.UserDTO;
import com.test.rahmasameh.mvvm.repository.Repository;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class UsersViewModel extends ViewModel {

    Repository repository;

    public MutableLiveData<List<UserDTO>> userMutableLiveData
            = new MutableLiveData<>();

    public MutableLiveData<String> status_response = new MutableLiveData<>();

    @Inject
    public UsersViewModel(Repository repository) {
        this.repository = repository;
    }

    public void getUserList(int page) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page", String.valueOf(page));
         repository.getUsers(hashMap).enqueue(new Callback<PageDTO>() {
            @Override
            public void onResponse(Call<PageDTO> call, Response<PageDTO> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null && response.body().getData() != null && response.body().getData().size() > 0) {
                        userMutableLiveData.setValue(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<PageDTO> call, Throwable t) {
              //  status_response.setValue("Failure");

            }
        });


    }

    public MutableLiveData<List<UserDTO>> getUsers(){
       return userMutableLiveData;
    }

}
