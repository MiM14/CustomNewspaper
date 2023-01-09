package com.example.rss_aggregator_2022.features.domain

import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either
import kotlinx.coroutines.flow.Flow

interface RssRepository {
    suspend fun createRss(name:String, urlRss:String)
    suspend fun getSourceRss(): Flow<Either<ErrorApp, List<Rss>>>
}