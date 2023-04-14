package com.moaimar.custom_newspaper.features.rssfeed.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val NEWS_TABLE_NAME = "news"

@Entity(tableName = NEWS_TABLE_NAME)
data class NewsEntity(
    @ColumnInfo val title: String,
    @ColumnInfo val description: String,
    @PrimaryKey @ColumnInfo val link: String,
    @ColumnInfo val pubDate: String,
    @ColumnInfo val creator: String,
    @ColumnInfo val thumbnail: String,
)
