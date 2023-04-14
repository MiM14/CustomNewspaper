package com.moaimar.custom_newspaper.features.rssfeed.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moaimar.custom_newspaper.app.extensions.loadUrl
import com.moaimar.custom_newspaper.databinding.ItemRssFeedBinding
import com.moaimar.custom_newspaper.features.rssfeed.domain.News

class NewsViewHolder (private val view: View) : RecyclerView.ViewHolder(view) {

    fun render(model : News){
        val binding= ItemRssFeedBinding.bind(view)

        binding.apply {
            image.loadUrl(model.thumbnail)
            title.text = model.title
            description.text = model.description
            date.text = model.pubDate
        }
    }
}