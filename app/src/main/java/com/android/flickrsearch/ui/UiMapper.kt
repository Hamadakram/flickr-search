package com.android.flickrsearch.ui

import com.android.flickrsearch.domain.model.Photo

fun Photo.asUiModel() = UiPhoto(
    url = url,
    name = name
)