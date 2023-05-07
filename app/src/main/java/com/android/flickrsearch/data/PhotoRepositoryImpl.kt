package com.android.flickrsearch.data

import com.android.flickrsearch.data.mapper.PhotoMapper
import com.android.flickrsearch.data.source.FlickrService
import com.android.flickrsearch.domain.PhotoRepository
import com.android.flickrsearch.domain.model.Photo
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val flickrService: FlickrService,
    private val photoMapper: PhotoMapper
) : PhotoRepository {
    override suspend fun search(query: String): List<Photo> {
        return flickrService.search(query).photos.photo.map { model ->
            photoMapper.toDomainModel(model)
        }
    }
}