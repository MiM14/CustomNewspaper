package com.moaimar.custom_newspaper.features.rssmanagement.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.moaimar.custom_newspaper.app.commons.KSerializer
import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.app.functional.Either
import com.moaimar.custom_newspaper.app.functional.right
import com.moaimar.custom_newspaper.features.rssmanagement.data.local.LocalDataSource
import com.moaimar.custom_newspaper.features.rssmanagement.domain.Rss
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "name_datastore_file")

class DSLocalDataSource(private val context: Context, private val serializer: KSerializer) :
    LocalDataSource {

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
