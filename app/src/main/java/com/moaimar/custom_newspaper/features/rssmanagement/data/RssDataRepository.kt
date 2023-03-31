package com.moaimar.custom_newspaper.features.rssmanagement.data

import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either
import com.moaimar.custom_newspaper.features.rssmanagement.data.local.LocalDataSource
import com.moaimar.custom_newspaper.features.rssmanagement.domain.Rss
import com.moaimar.custom_newspaper.features.rssmanagement.domain.RssRepository
import kotlinx.coroutines.flow.Flow

class RssDataRepository(private val localSource: LocalDataSource) : RssRepository {
    override suspend fun createRss(urlRss: String, name: String) =
        localSource.saveRss(urlRss, name)

    override suspend fun getSourceRss(): Flow<Either<ErrorApp, List<Rss>>> =
        localSource.obtain()

    override suspend fun deleteRss(urlRss: String) {
        localSource.delete(urlRss)
    }
}