package com.example.rss_aggregator_2022.features.rssmanagement.domain

class SaveRssUseCase(private val repository: RssRepository) {
    suspend operator fun invoke(urlRss: String, name: String) {
        repository.createRss(urlRss, name)
    }
}