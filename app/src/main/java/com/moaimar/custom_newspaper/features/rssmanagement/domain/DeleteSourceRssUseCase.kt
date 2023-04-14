package com.moaimar.custom_newspaper.features.rssmanagement.domain

import javax.inject.Inject

class DeleteSourceRssUseCase @Inject constructor(private val repository: RssRepository) {
    suspend operator fun invoke(urlRss: String) {
        repository.deleteRss(urlRss)
    }
}