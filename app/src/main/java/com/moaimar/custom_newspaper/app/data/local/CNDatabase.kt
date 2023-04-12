package com.moaimar.custom_newspaper.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.moaimar.custom_newspaper.BuildConfig
import com.moaimar.custom_newspaper.features.rssfeed.data.local.NewsDao
import com.moaimar.custom_newspaper.features.rssfeed.data.local.NewsEntity

@Database(
    entities = [NewsEntity::class],
    version = BuildConfig.VERSION_CODE,
    exportSchema = false
)
abstract class CNDatabase() : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}