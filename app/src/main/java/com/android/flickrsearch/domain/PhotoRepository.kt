package com.android.flickrsearch.domain

import com.android.flickrsearch.domain.model.Photo

interface PhotoRepository {
    suspend fun search(query: String): List<Photo>
}