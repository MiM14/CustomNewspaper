package com.moaimar.custom_newspaper.features.rssmanagement.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.features.rssmanagement.domain.DeleteSourceRssUseCase
import com.moaimar.custom_newspaper.features.rssmanagement.domain.GetSourceRssUseCase
import com.moaimar.custom_newspaper.features.rssmanagement.domain.Rss
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RssManagementViewModel(
    private val getSourceRssUseCase: GetSourceRssUseCase,
    private val deleteSourceRssUseCase: DeleteSourceRssUseCase
) : ViewModel() {
    private val _managerUiState: MutableLiveData<ManagerUiState> = MutableLiveData()
    val managerUiState = _managerUiState

    fun obtainRss() {
        viewModelScope.launch(Dispatchers.IO) {
            getSourceRssUseCase.invoke().collect { either ->
                either.fold({ errorApp ->
                    _managerUiState.postValue(
                        ManagerUiState(error = errorApp)
                    )
                }, { feed ->
                    _managerUiState.postValue(
                        ManagerUiState(managerFeed = feed, error = null)
                    )
                }
                )
            }
        }
    }

    fun delete(urlRss: String) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteSourceRssUseCase(urlRss)
        }
    }

    data class ManagerUiState(
        val managerFeed: List<Rss> = emptyList(),
        val error: ErrorApp? = null
    )
}