package com.moaimar.custom_newspaper.features.rssmanagement.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moaimar.custom_newspaper.databinding.ItemRssManagementBinding
import com.moaimar.custom_newspaper.features.rssmanagement.domain.Rss

class RssManagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemRssManagementBinding.bind(view)
    fun bind(model: Rss, itemClick: ((String) -> Unit?)?) {
        binding.rssSourceName.text = model.name
        binding.rssSourceUrl.text = model.urlRss
        binding.deleteIcon.setOnClickListener {
            itemClick?.invoke(model.urlRss)
        }
    }
}