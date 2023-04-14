package com.moaimar.custom_newspaper.features.rssfeed.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.moaimar.custom_newspaper.features.rssfeed.domain.News

class NewsDiff(): DiffUtil.ItemCallback<News>(){
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.link ==newItem.link
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }

}