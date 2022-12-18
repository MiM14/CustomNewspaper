package com.example.rss_aggregator_2022.features.rssmanagement.domain

class SaveRssUseCase(private val repository: RssRepository) {
    suspend operator fun invoke(name: String, urlRss: String) {
        repository.createRss(name, urlRss)
    }
}