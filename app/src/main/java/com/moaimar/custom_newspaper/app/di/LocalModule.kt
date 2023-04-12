package com.moaimar.custom_newspaper.app.di

import android.content.Context
import androidx.room.Room
import com.moaimar.custom_newspaper.app.commons.GsonJSerializer
import com.moaimar.custom_newspaper.app.data.local.CNDatabase
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

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): CNDatabase {
        return Room.databaseBuilder(
            context,
            CNDatabase::class.java,
            "Custom Newspaper Database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun dataStoreManager(@ApplicationContext appContext: Context): DSRssLocalDataSource =
        DSRssLocalDataSource(appContext, GsonJSerializer())

}