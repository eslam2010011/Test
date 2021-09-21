package com.test.rahmasameh.mvvm_kotlin

import dagger.hilt.android.AndroidEntryPoint
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.test.rahmasameh.R
 import androidx.recyclerview.widget.LinearLayoutManager
import com.test.rahmasameh.mvvm_kotlin.adapter.UsersAdapter
import com.test.rahmasameh.mvvm_kotlin.model.UserDTO
import com.test.rahmasameh.mvvm_kotlin.viewmodel.UsersViewModel_kotlin
import javax.inject.Named

@AndroidEntryPoint
 class MainActivity_kotlin : AppCompatActivity() {
    private val usersViewModel by viewModels<UsersViewModel_kotlin>()
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
        usersViewModel.getUserList(1)
        usersViewModel.users.observe(this, { userDTOS ->
            setAdapter(userDTOS)
            userDTOS.forEach {
                Log.d("Tag_Data",it.first_name +" "+it.last_name)
            }
        })
    }

    fun setView() {
        recyclerView = findViewById<RecyclerView>(R.id.RecyclerView_id)
    }

    fun setAdapter(userDTOS: List<UserDTO>) {
        val usersAdapter = UsersAdapter(userDTOS)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = usersAdapter
    }
}