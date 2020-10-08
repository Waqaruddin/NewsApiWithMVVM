package com.example.newswithmvvm.ui.auth

import androidx.lifecycle.LiveData
import com.example.newswithmvvm.data.models.Article

interface NewsListener {

    fun onStarted()
    fun onSuccessful(response: LiveData<ArrayList<Article>>)
    fun failure(message:String)
}