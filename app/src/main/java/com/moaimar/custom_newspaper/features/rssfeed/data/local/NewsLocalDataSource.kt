package com.moaimar.custom_newspaper.features.rssfeed.data.local

import com.moaimar.custom_newspaper.features.rssfeed.domain.News
import javax.inject.Inject

class NewsLocalDataSource @Inject constructor(private val newsDao: NewsDao) {

    fun getNews(): List<News> =
        newsDao.getNews().map {
            it.toDomain()
        }

    fun save(news: List<News>) {
        val listOfNews = news.map { it.toEntity() }
        newsDao.save(*listOfNews.toTypedArray())
    }

    fun delete() {
        newsDao.delete()
    }

}