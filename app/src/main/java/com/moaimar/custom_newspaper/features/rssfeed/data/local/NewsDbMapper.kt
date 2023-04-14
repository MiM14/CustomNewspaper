package com.moaimar.custom_newspaper.features.rssfeed.data.local

import com.moaimar.custom_newspaper.features.rssfeed.domain.News

fun NewsEntity.toDomain() =
    News(
        this.title,
        this.description,
        this.link,
        this.pubDate,
        this.creator,
        this.thumbnail,
    )

fun News.toEntity() =
    NewsEntity(
        this.title,
        this.description,
        this.link,
        this.pubDate,
        this.creator,
        this.thumbnail
    )
