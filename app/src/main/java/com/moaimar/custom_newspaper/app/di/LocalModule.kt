package com.moaimar.custom_newspaper.app.di

import android.content.Context
import com.moaimar.custom_newspaper.app.commons.GsonJSerializer
import com.moaimar.custom_newspaper.features.rssmanagement.data.local.datastore.DSRssLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun dataStoreManager(@ApplicationContext appContext: Context): DSRssLocalDataSource =
        DSRssLocalDataSource(appContext, GsonJSerializer())

}