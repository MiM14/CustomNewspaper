package com.moaimar.custom_newspaper.features.rssmanagement.domain

class DeleteSourceRssUseCase(private val repository: RssRepository) {
    suspend operator fun invoke(urlRss: String) {
        repository.deleteRss(urlRss)
    }
}