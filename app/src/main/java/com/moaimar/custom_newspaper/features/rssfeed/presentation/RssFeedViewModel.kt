package com.moaimar.custom_newspaper.features.rssfeed.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moaimar.custom_newspaper.app.domain.ErrorApp
import com.moaimar.custom_newspaper.features.rssfeed.domain.GetNewsUseCase
import com.moaimar.custom_newspaper.features.rssfeed.domain.News
import com.moaimar.custom_newspaper.features.rssfeed.domain.RefreshFeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RssFeedViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val refreshFeedUseCase: RefreshFeedUseCase
): ViewModel() {

    private val _uiState: MutableLiveData<UiState> = MutableLiveData()
    val uiState: LiveData<UiState> = _uiState

    fun getNewsList() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getNewsUseCase.invoke().fold({ error ->
                _uiState.postValue(
                    UiState(isLoading = false, error = error)
                )
            }, { news ->
                _uiState.postValue(
                    UiState(isLoading = false, news = news)
                )
            })

        }
    }

    fun refreshFeed() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            refreshFeedUseCase.invoke().fold({ error ->
                _uiState.postValue(UiState(error = error))
            }, { news ->
                _uiState.postValue(UiState(news = news))
            })
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val news: List<News>? = null,
        val error: ErrorApp? = null
    )

}