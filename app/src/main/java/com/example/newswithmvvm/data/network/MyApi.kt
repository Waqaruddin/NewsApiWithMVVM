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

    @GET("everything?domains=wsj.com&apiKey=7ba67bce9dfb416bac6378b4845e3f80")
    fun getNews(): Call<NewsResponse>


    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config.BASE_URL)
                .build()
                .create(MyApi::class.java)
        }
    }
}