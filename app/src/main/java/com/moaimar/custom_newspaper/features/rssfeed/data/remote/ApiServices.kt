package com.moaimar.custom_newspaper.features.rssfeed.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServices {
@GET
suspend fun getRss(@Url url: String): Response<RssApiModel>
}