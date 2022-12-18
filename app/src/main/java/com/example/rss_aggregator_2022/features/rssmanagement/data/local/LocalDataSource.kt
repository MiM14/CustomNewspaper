package com.example.rss_aggregator_2022.features.rssmanagement.data.local

import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either
import com.example.rss_aggregator_2022.features.rssmanagement.domain.Rss
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun saveRss(urlRss: String, name: String)
    fun obtain() : Flow<Either<ErrorApp,List<Rss>>>
    suspend fun delete(urlRss: String)

}