package com.moaimar.custom_newspaper.features.rssfeed.di

import com.moaimar.custom_newspaper.features.rssfeed.data.NewsDataRepository
import com.moaimar.custom_newspaper.features.rssfeed.domain.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NewsModule {

    @Binds
    abstract fun bindNewsRepository(repository: NewsDataRepository): NewsRepository

}