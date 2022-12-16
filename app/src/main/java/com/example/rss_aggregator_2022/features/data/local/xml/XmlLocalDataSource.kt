package com.example.rss_aggregator_2022.features.data.local.xml

import android.content.SharedPreferences
import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either
import com.example.rss_aggregator_2022.features.data.local.LocalDataSource
import com.example.rss_aggregator_2022.features.domain.Rss
import kotlinx.coroutines.flow.Flow

class XmlLocalDataSource(sharedPref: SharedPreferences): LocalDataSource {
    private val editor = sharedPref.edit()

    override suspend fun saveRss(name: String, urlRss: String) {
        editor.putString(urlRss, name)
        editor.apply()
    }

    override fun obtain(): Flow<Either<ErrorApp, List<Rss>>> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(urlRss: String) {
        TODO("Not yet implemented")
    }
}