package com.synerzip.assigment.ui.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.synerzip.assigment.R

import com.synerzip.assigment.modeltest.Entry

import kotlinx.android.synthetic.main.single_news_item_layout.view.*

class NewsRecyclerViewAdapter(
  //  private var newsList: ArrayList<NewsModell>
    private var newsList: List<Entry>
) :
    RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_news_item_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = newsList.size

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsList[position]

       /* Glide.with(holder.itemView.context)  //2
            .load(item.imImage?.get(3)?.label) //3
            .placeholder(R.drawable.ic_placeholder)
          //  .centerCrop()//4

            .dontAnimate()
            .into(holder.itemView.newsImageView) //8*/



        //Loading Image from URL
        Picasso.with(holder.itemView.context)
            .load(item.imImage?.get(3)?.label)
            .placeholder(R.drawable.ic_placeholder)   // optional
                 // optional
            .resize(200,200)                        // optional
            .into(holder.itemView.newsImageView);

        holder.itemView.titleTextView.text = "Category: "+item.category?.attributes?.term
        holder.itemView.descriptionTextView.text ="Title: "+ item.title?.label
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}