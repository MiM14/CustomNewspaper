package com.moaimar.custom_newspaper.features.rssmanagement.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moaimar.custom_newspaper.R
import com.moaimar.custom_newspaper.features.rssmanagement.domain.Rss

class RssManagerAdapter() : RecyclerView.Adapter<RssManagerViewHolder>() {

    private val dataItems = mutableListOf<Rss>()
    private var itemClick: ((String) -> Unit?)? = null

    fun setOnClick(itemClick: (String) -> Unit) {
        this.itemClick = itemClick
    }

    fun setDataItems(rss: List<Rss>) {
        dataItems.clear()
        dataItems.addAll(rss)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssManagerViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rss_management, parent, false)

        return RssManagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RssManagerViewHolder, position: Int) {
        holder.bind(dataItems[position], itemClick)
    }

    override fun getItemCount() = dataItems.size
}