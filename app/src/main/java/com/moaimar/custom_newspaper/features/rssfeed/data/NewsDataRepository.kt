package com.moaimar.custom_newspaper.features.rssfeed.data

import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either
import com.moaimar.custom_newspaper.app.functional.right
import com.moaimar.custom_newspaper.features.rssfeed.data.local.NewsLocalDataSource
import com.moaimar.custom_newspaper.features.rssfeed.data.remote.NewsRemoteDataSource
import com.moaimar.custom_newspaper.features.rssfeed.domain.News
import com.moaimar.custom_newspaper.features.rssfeed.domain.NewsRepository
import com.moaimar.custom_newspaper.features.rssmanagement.data.local.datastore.DSRssLocalDataSource
import javax.inject.Inject

class NewsDataRepository @Inject constructor(
    private val localDataSource: NewsLocalDataSource,
    private val remoteDataSource: NewsRemoteDataSource,
    private val rssManager: DSRssLocalDataSource
) : NewsRepository {

    override suspend fun getNews(): Either<ErrorApp, List<News>> {
        val news = mutableListOf<News>()
        rssManager.getURLs().forEach {
            remoteDataSource.getNews(it).map { newsList ->
                newsList.forEach { remoteNews ->
                    news.add(remoteNews)
                }
            }
        }
        localDataSource.save(news)
        return localDataSource.getNews().right()

    }

    override suspend fun refreshFeed(): Either<ErrorApp, List<News>> {
        localDataSource.delete()
        return getNews()
    }

}