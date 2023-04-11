package com.moaimar.custom_newspaper.features.rssmanagement.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.moaimar.custom_newspaper.app.commons.KSerializer
import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either
import com.moaimar.custom_newspaper.app.functional.right
import com.moaimar.custom_newspaper.features.rssmanagement.data.local.RssLocalDataRepository
import com.moaimar.custom_newspaper.features.rssmanagement.domain.Rss
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore by preferencesDataStore(name = "name_datastore_file")

class DSRssLocalDataSource @Inject constructor(@ApplicationContext private val context: Context, private val serializer: KSerializer) :
    RssLocalDataRepository {

    override suspend fun saveRss(urlRss: String, name: String) {
        context.dataStore.edit {
            it[stringPreferencesKey(urlRss)] = serializer.toJson(Rss(urlRss, name))
        }
    }

    override fun obtain(): Flow<Either<ErrorApp, List<Rss>>> {
        return context.dataStore.data.map { preferences ->
            preferences.asMap().values.map {
                serializer.fromJson(it as String, Rss::class.java)
            }.right()
        }
    }

    override suspend fun delete(urlRss: String) {
        context.dataStore.edit {
            it.remove(stringPreferencesKey(urlRss))
        }
    }
}
