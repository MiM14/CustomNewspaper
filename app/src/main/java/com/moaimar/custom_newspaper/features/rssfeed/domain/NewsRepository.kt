package com.moaimar.custom_newspaper.features.rssfeed.domain

import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either

interface NewsRepository {
    suspend fun getNews(): Either<ErrorApp, List<News>>

    suspend fun refreshFeed(): Either<ErrorApp, List<News>>
}