package com.moaimar.custom_newspaper.features.rssmanagement.di

import com.moaimar.custom_newspaper.features.rssmanagement.data.RssDataRepository
import com.moaimar.custom_newspaper.features.rssmanagement.data.local.RssLocalDataRepository
import com.moaimar.custom_newspaper.features.rssmanagement.data.local.datastore.DSRssLocalDataSource
import com.moaimar.custom_newspaper.features.rssmanagement.domain.RssRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RssManagerModule {

    @Binds
    abstract fun bindRssRepository(repository: RssDataRepository): RssRepository

    @Binds
    abstract fun bindRssLocalRepository(repository: DSRssLocalDataSource): RssLocalDataRepository

}