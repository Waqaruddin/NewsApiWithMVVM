package com.example.newswithmvvm.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.example.newswithmvvm.R
import com.example.newswithmvvm.data.models.Article
import com.example.newswithmvvm.databinding.RowAdapterNewsBinding
import com.example.newswithmvvm.ui.home.NewsActivity
import kotlinx.android.synthetic.main.row_adapter_news.view.*

class AdapterNews (var mContext: Context, var mList:ArrayList<Article>):RecyclerView.Adapter<AdapterNews.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//
//        //var inflater = LayoutInflater.from(parent.context)
//        var binding = RowAdapterNewsBinding.inflate(LayoutInflater.from(parent.context))
//        return MyViewHolder(binding)

        var view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_news, parent, false)
        return MyViewHolder(view)

//        var inflater = LayoutInflater.from(parent.context)
//        var binding = RowAdapterNewsBinding.inflate(inflater)
//        return MyViewHolder(binding)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var article = mList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(it: ArrayList<Article>) {
        mList = it
        notifyDataSetChanged()

    }

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(article:Article){
            itemView.text_view_title.text = article.title
            itemView.text_view_desc.text = article.description
//            mBinding.textViewTitle.text = article.title
//            mBinding.textViewDesc.text = article.description

            itemView.setOnClickListener {
                var intent = Intent(mContext, NewsActivity::class.java)
                intent.putExtra(Article.KEY_ARTICLE, article)
                mContext.startActivity(intent)
            }

        }
    }
}