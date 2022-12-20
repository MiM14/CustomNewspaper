package com.moaimar.rss_aggregator_2022.features.rssmanagement.domain

import com.moaimar.rss_aggregator_2022.app.domain.ErrorApp
import com.moaimar.rss_aggregator_2022.app.functional.Either
import kotlinx.coroutines.flow.Flow

interface RssRepository {
    suspend fun createRss(urlRss: String, name: String)
    suspend fun getSourceRss(): Flow<Either<ErrorApp, List<Rss>>>
    suspend fun deleteRss(urlRss: String)
}