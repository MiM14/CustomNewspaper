package com.moaimar.custom_newspaper.features.rssfeed.data.remote


import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class RetrofitClient{
    private val apiEndPoints: ApiServices

    private fun buildApiEndPoints() = buildApiClient().create(ApiServices::class.java)

    init {
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildApiClient(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .baseUrl("https://www.google.es")
            .build()
    }
    suspend fun getRss(url: String): Either<ErrorApp, RssApiModel> {
        val response = apiEndPoints.getRss(url).body()
        return if(response == null){
            Either.Left(ErrorApp.DataError())
        }else{
            Either.Right(response)
        }
    }
}