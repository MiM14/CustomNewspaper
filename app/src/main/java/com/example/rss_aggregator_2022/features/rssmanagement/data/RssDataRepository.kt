package com.example.rss_aggregator_2022.features.rssmanagement.data

import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either
import com.example.rss_aggregator_2022.features.rssmanagement.data.local.LocalDataSource
import com.example.rss_aggregator_2022.features.rssmanagement.domain.Rss
import com.example.rss_aggregator_2022.features.rssmanagement.domain.RssRepository
import kotlinx.coroutines.flow.Flow

class RssDataRepository(private val localSource: LocalDataSource) : RssRepository {
    override suspend fun createRss(name: String, urlRss: String) =
        localSource.saveRss(name,urlRss)

    override suspend fun getSourceRss(): Flow<Either<ErrorApp, List<Rss>>> =
        localSource.obtain()

    override suspend fun deleteRss(urlRss: String) {
        localSource.delete(urlRss)
    }
}