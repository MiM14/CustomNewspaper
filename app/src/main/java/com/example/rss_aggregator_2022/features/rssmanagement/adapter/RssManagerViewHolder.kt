package com.example.rss_aggregator_2022.features.rssmanagement.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rss_aggregator_2022.databinding.ItemRssManagementBinding

import com.example.rss_aggregator_2022.features.domain.Rss

class RssManagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemRssManagementBinding.bind(view)
    fun bind(model: Rss,itemClick:((String) -> Unit?)?) {
        binding.rssSourceName.text = model.name
        binding.rssSourceUrl.text = model.urlRss
        binding.deleteIcon.setOnClickListener {
            itemClick?.invoke(model.urlRss)
        }
    }
}