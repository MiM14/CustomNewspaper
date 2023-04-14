package com.moaimar.custom_newspaper.features.rssfeed.domain

import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repository: NewsRepository){

    suspend operator fun invoke(): Either<ErrorApp, List<News>> =
        repository.getNews()
}