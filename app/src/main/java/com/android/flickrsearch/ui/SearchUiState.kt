package com.android.flickrsearch.ui

import androidx.annotation.StringRes
import com.android.flickrsearch.R

sealed class SearchUiState(
    @StringRes val message: Int
) {
    object Initial : SearchUiState(R.string.initial_message)
    object Loading : SearchUiState(R.string.loading)
    class Error(val exception: String) : SearchUiState(R.string.error_message)
    class Content(val content: List<UiPhoto>) : SearchUiState(message = -1)
}

data class UiPhoto(
    val url: String,
    val name: String
)
