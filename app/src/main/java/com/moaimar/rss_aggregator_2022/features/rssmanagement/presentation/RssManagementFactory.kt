package com.moaimar.rss_aggregator_2022.features.rssmanagement.presentation

import android.content.Context
import com.moaimar.rss_aggregator_2022.app.commons.GsonJSerializer
import com.moaimar.rss_aggregator_2022.features.rssmanagement.data.RssDataRepository
import com.moaimar.rss_aggregator_2022.features.rssmanagement.data.local.datastore.DSLocalDataSource
import com.moaimar.rss_aggregator_2022.features.rssmanagement.domain.DeleteSourceRssUseCase
import com.moaimar.rss_aggregator_2022.features.rssmanagement.domain.GetSourceRssUseCase
import com.moaimar.rss_aggregator_2022.features.rssmanagement.domain.SaveRssUseCase

class RssManagementFactory {

    private fun injectRepository(context: Context): RssDataRepository {
        return RssDataRepository(
            DSLocalDataSource(
                context, GsonJSerializer()
            )
        )
    }

    fun injectRssManagementViewModel(context: Context): RssManagementViewModel {
        return RssManagementViewModel(
            GetSourceRssUseCase(
                injectRepository(context)
            ),
            DeleteSourceRssUseCase(
                injectRepository(context)
            )
        )

    }

    fun injectUserFormViewModel(context: Context): UserFormViewModel {
        return UserFormViewModel(
            SaveRssUseCase(injectRepository(context))
        )
    }
}
