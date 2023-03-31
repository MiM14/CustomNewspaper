package com.moaimar.custom_newspaper.features.rssmanagement.domain

class SaveRssUseCase(private val repository: RssRepository) {
    suspend operator fun invoke(urlRss: String, name: String) {
        repository.createRss(urlRss, name)
    }
}