package com.android.flickrsearch.data.mapper

import com.android.flickrsearch.data.model.PhotoModel
import com.android.flickrsearch.domain.model.Photo
import javax.inject.Inject


class PhotoMapper @Inject constructor() {
    companion object {
        const val FLICKR_IMAGE_HOST = "https://live.staticflickr.com/"
    }

    fun toDomainModel(photo: PhotoModel): Photo = Photo(
        name = photo.title,
        url = photo.buildImageUrl()
    )

    private fun PhotoModel.buildImageUrl(): String {
        return "$FLICKR_IMAGE_HOST${server}/${id}_${secret}.jpg"
    }
}