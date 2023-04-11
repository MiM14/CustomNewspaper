package com.moaimar.custom_newspaper.features.rssfeed.domain

data class News(
    val title: String,
    val description : String,
    val link : String,
    val pubDate:String,
    val creator: String,
    val thumbnail:String,
)
