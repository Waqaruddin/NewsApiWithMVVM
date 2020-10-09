package com.example.newswithmvvm.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newswithmvvm.R
import com.example.newswithmvvm.data.models.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    var article: Article? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        article = intent.getSerializableExtra(Article.KEY_ARTICLE) as Article?

        init()
    }

    private fun init() {
        text_view_title.text = article?.title
        text_view_desc.text = article?.description
        Picasso.get()
            .load(article?.urlToImage)
            .into(image_view)
    }
}