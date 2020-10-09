package com.example.newswithmvvm.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newswithmvvm.data.models.Article
import com.example.newswithmvvm.data.models.NewsResponse
import com.example.newswithmvvm.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository{

    fun getData(): LiveData<ArrayList<Article>>{

        val newsResponse = MutableLiveData<ArrayList<Article>>()
        MyApi().getNews()
            .enqueue(object:Callback<NewsResponse>{
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if(response.isSuccessful){
                        newsResponse.value = response.body()?.articles
                        Log.d("abc", response.body()!!.articles[0].title )

                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

                }

            })
        return newsResponse
    }



}