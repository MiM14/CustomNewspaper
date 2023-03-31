package com.moaimar.custom_newspaper.features.rssmanagement.domain

import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either
import kotlinx.coroutines.flow.Flow

interface RssRepository {
    suspend fun createRss(urlRss: String, name: String)
    suspend fun getSourceRss(): Flow<Either<ErrorApp, List<Rss>>>
    suspend fun deleteRss(urlRss: String)
}