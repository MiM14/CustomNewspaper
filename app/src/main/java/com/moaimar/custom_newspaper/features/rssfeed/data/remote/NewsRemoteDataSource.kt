package com.moaimar.custom_newspaper.features.rssfeed.data.remote

import com.moaimar.custom_newspaper.app.data.remote.apiCall
import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either
import com.moaimar.custom_newspaper.features.rssfeed.domain.News
import javax.inject.Inject


class NewsRemoteDataSource @Inject constructor(private val apiClient: ApiEndPoints) {

    suspend fun getNews(url: String): Either<ErrorApp, List<News>> {
        return apiCall {
            apiClient.getNews(url)
        }.map { apiModel ->
            apiModel.items!!.map {
                it.toDomain()
            }
        }
    }

}