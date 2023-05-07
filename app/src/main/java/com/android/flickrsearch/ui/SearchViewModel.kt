package com.android.flickrsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.flickrsearch.domain.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private var searchJob: Job? = null

    private val _uiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState.Initial)
    val uiState: StateFlow<SearchUiState> = _uiState

    fun search(query: String, scope: CoroutineScope = viewModelScope) {
        searchJob?.cancel()
        searchJob = scope.launch {
            _uiState.value = SearchUiState.Loading
            try {
                val photos = photoRepository.search(query).map {
                    it.asUiModel()
                }
                _uiState.value = SearchUiState.Content(
                    content = photos
                )
            } catch (exception: Exception) {
                _uiState.value = SearchUiState.Error(exception = exception.localizedMessage ?: "")
            }
        }
    }
}