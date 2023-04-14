package com.moaimar.custom_newspaper.features.rssfeed.data.remote

import com.moaimar.custom_newspaper.features.rssfeed.domain.News

fun ItemApiModel.toDomain()=
    News(
        this.title ?: this.mediaTitle ?: "",
        this.description ?: this.mediaDescription ?: "",
        this.link ?: "",
        this.pubDate ?: "",
        this.creator ?: "",
        this.thumbnail ?: ""
    )