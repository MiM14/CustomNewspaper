package com.moaimar.custom_newspaper.features.rssmanagement.data.local

import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either
import com.moaimar.custom_newspaper.features.rssmanagement.domain.Rss
import kotlinx.coroutines.flow.Flow

interface RssLocalDataRepository {
    suspend fun saveRss(urlRss: String, name: String)
    fun obtain() : Flow<Either<ErrorApp,List<Rss>>>
    suspend fun delete(urlRss: String)

}