package com.test.rahmasameh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.test.rahmasameh.mvvm.adapter.UsersAdapter;
import com.test.rahmasameh.mvvm.model.UserDTO;
import com.test.rahmasameh.mvvm.viewmodel.UsersViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        UsersViewModel usersViewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        usersViewModel.getUserList(1);
        usersViewModel.userMutableLiveData.observe(this, new Observer<List<UserDTO>>() {
            @Override
            public void onChanged(List<UserDTO> userDTOS) {
                setAdapter(userDTOS);
                for (UserDTO userDTO : userDTOS) {
                    Log.d("Tag_Data", userDTO.getFirstName() + " " + userDTO.getLastName());
                }
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