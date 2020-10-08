package com.example.newswithmvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.newswithmvvm.data.repositories.NewsRepository

class NewsViewModel :ViewModel(){

    var title:String? = null
    var description:String? = null

    var newsListener:NewsListener? = null

    fun onGetDataButtonClick(view: View){
        val newsResponse = NewsRepository().getData()
        newsListener?.onSuccessful(newsResponse)
        newsListener?.failure("Failure")
    }

}