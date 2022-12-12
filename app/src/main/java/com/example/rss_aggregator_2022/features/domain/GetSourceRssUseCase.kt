package com.example.rss_aggregator_2022.features.domain

import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either
import kotlinx.coroutines.flow.Flow

class GetSourceRssUseCase(private val repository: RssRepository){
    suspend operator fun invoke(): Flow<Either<ErrorApp, List<Rss>>> =
        repository.getSourceRss()
}