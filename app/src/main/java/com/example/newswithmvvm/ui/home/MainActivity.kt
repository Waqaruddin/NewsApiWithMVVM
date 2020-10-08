package com.example.newswithmvvm.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newswithmvvm.R
import com.example.newswithmvvm.adapters.AdapterNews
import com.example.newswithmvvm.data.models.Article
import com.example.newswithmvvm.databinding.ActivityMainBinding
import com.example.newswithmvvm.ui.auth.NewsListener
import com.example.newswithmvvm.ui.auth.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsListener {
    var mList:ArrayList<Article> = ArrayList()
    private var adapterNews:AdapterNews? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.newsListener = this

        init()
    }

    private fun init() {

        adapterNews = AdapterNews(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapterNews
    }

    override fun onStarted() {


    }

    override fun onSuccessful(response: LiveData<ArrayList<Article>>) {
        response.observe(this, Observer {
            adapterNews?.setData(it)
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        })
    }


    override fun failure(message: String) {

    }
}