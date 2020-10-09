package com.example.newswithmvvm.data.network

import android.graphics.Bitmap
import com.example.newswithmvvm.app.Config
import com.example.newswithmvvm.data.models.NewsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {

    @GET("top-headlines?country=us&category=business&apiKey=a1c63f6fa6a645088799c895f54f5ed6")
    fun getNews(): Call<NewsResponse>


    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}

