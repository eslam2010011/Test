package com.test.rahmasameh.mvvm_kotlin.network

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.test.rahmasameh.R
import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import android.widget.TextView
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
 import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class Webservice_kotlin {
    @Provides
    @Singleton
     fun provideWebservicekotlin(): RequestService_kotlin {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create()).baseUrl("https://reqres.in/api/")
            .build().create(RequestService_kotlin::class.java)
    }
}