package com.moaimar.custom_newspaper.features.rssmanagement.domain

import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSourceRssUseCase @Inject constructor(private val repository: RssRepository){
    suspend operator fun invoke(): Flow<Either<ErrorApp, List<Rss>>> {
        return repository.getSourceRss()
    }
}