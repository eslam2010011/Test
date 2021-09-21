package com.test.rahmasameh.pure;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.rahmasameh.R;
import com.test.rahmasameh.mvvm.adapter.UsersAdapter;
import com.test.rahmasameh.mvvm.model.PageDTO;
import com.test.rahmasameh.mvvm.model.UserDTO;
import com.test.rahmasameh.pure.network.ResteasyClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity_Pure extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page", String.valueOf("1"));
        ResteasyClient.getInstance().getAppService().tPage(hashMap).enqueue(new Callback<PageDTO>() {
            @Override
            public void onResponse(Call<PageDTO> call, Response<PageDTO> response) {
                if (response.body() != null) {
                    setAdapter(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<PageDTO> call, Throwable t) {

            }
        });

    }

    public void setView() {
        recyclerView = findViewById(R.id.RecyclerView_id);

    }

    public void setAdapter(List<UserDTO> userDTOS) {
        UsersAdapter usersAdapter = new UsersAdapter(userDTOS);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(usersAdapter);


    }
}