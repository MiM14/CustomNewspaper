package com.moaimar.custom_newspaper.features.rssmanagement.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moaimar.custom_newspaper.features.rssmanagement.domain.SaveRssUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserFormViewModel @Inject constructor(private val saveRssUseCase: SaveRssUseCase) : ViewModel() {

    private val _formUiState: MutableLiveData<FormUiState> = MutableLiveData()
    val formUiState: MutableLiveData<FormUiState> = _formUiState

    fun saveRss(name: String, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveRssUseCase(name, url)
            _formUiState.postValue(FormUiState(isSuccess = true))
        }
    }

    data class FormUiState(val isSuccess: Boolean = false)
}