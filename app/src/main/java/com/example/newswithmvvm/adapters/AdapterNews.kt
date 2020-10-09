package com.example.newswithmvvm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newswithmvvm.R
import com.example.newswithmvvm.data.models.Article
import com.example.newswithmvvm.databinding.RowAdapterNewsBinding
import kotlinx.android.synthetic.main.row_adapter_news.view.*

class AdapterNews (var mContext: Context, var mList:ArrayList<Article>):RecyclerView.Adapter<AdapterNews.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = RowAdapterNewsBinding.inflate(inflater)
        return MyViewHolder(binding)

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

    inner class MyViewHolder(mBinding:RowAdapterNewsBinding):RecyclerView.ViewHolder(mBinding.root){
        fun bind(article:Article){
            itemView.text_view_title.text = article.title
            itemView.text_view_desc.text = article.description
        }
    }
}