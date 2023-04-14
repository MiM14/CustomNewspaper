package com.moaimar.custom_newspaper.features.rssfeed.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.moaimar.custom_newspaper.R
import com.moaimar.custom_newspaper.features.rssfeed.domain.News
import javax.inject.Inject

class NewsAdapter @Inject constructor() : ListAdapter<News, NewsViewHolder>(
    AsyncDifferConfig.Builder(NewsDiff()).build()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rss_feed, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.render(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}