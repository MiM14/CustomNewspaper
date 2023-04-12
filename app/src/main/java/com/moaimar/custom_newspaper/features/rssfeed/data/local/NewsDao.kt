package com.moaimar.custom_newspaper.features.rssfeed.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    @Query("SELECT * FROM $NEWS_TABLE_NAME")
    fun getNews():  List<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg character :NewsEntity)

    @Query("DELETE FROM $NEWS_TABLE_NAME")
    fun delete()
}