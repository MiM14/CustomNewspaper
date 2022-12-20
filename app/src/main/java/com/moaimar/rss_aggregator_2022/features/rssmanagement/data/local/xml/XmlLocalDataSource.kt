package com.moaimar.rss_aggregator_2022.features.rssmanagement.data.local.xml

import android.content.SharedPreferences
import com.moaimar.rss_aggregator_2022.app.domain.ErrorApp
import com.moaimar.rss_aggregator_2022.app.functional.Either
import com.moaimar.rss_aggregator_2022.features.rssmanagement.data.local.LocalDataSource
import com.moaimar.rss_aggregator_2022.features.rssmanagement.domain.Rss
import kotlinx.coroutines.flow.Flow

class XmlLocalDataSource(sharedPref: SharedPreferences) : LocalDataSource {
    private val editor = sharedPref.edit()

    override suspend fun saveRss(urlRss: String, name: String) {
        editor.putString(name, urlRss)
        editor.apply()
    }

    override fun obtain(): Flow<Either<ErrorApp, List<Rss>>> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(urlRss: String) {
        TODO("Not yet implemented")
    }
}