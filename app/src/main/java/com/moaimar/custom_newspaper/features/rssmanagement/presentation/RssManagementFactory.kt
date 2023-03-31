package com.moaimar.custom_newspaper.features.rssmanagement.presentation

import android.content.Context
import com.moaimar.custom_newspaper.app.commons.GsonJSerializer
import com.moaimar.custom_newspaper.features.rssmanagement.data.RssDataRepository
import com.moaimar.custom_newspaper.features.rssmanagement.data.local.datastore.DSLocalDataSource
import com.moaimar.custom_newspaper.features.rssmanagement.domain.DeleteSourceRssUseCase
import com.moaimar.custom_newspaper.features.rssmanagement.domain.GetSourceRssUseCase
import com.moaimar.custom_newspaper.features.rssmanagement.domain.SaveRssUseCase

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
