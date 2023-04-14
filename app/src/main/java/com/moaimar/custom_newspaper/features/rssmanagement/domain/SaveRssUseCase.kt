package com.moaimar.custom_newspaper.features.rssmanagement.domain

import javax.inject.Inject

class SaveRssUseCase @Inject constructor(private val repository: RssRepository) {
    suspend operator fun invoke(urlRss: String, name: String) {
        repository.createRss(urlRss, name)
    }
}