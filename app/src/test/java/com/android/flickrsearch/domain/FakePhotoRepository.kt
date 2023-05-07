package com.android.flickrsearch.domain

import android.content.res.Resources.NotFoundException
import com.android.flickrsearch.domain.model.Photo

class FakePhotoRepository : PhotoRepository {

    private val photos: ArrayList<Photo> = arrayListOf()

    override suspend fun search(query: String): List<Photo> {
        return if (photos.isEmpty()) throw NotFoundException() else photos
    }

    fun add(photo: Photo) {
        photos.add(photo)
    }
}