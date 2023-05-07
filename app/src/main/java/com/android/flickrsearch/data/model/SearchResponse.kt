package com.android.flickrsearch.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    val photos: PhotosModel,
    val stat: String,
)

data class PhotosModel(
    val page: Long,
    val pages: Long,
    @SerializedName("perpage")
    val perPage: Long,
    val total: Long,
    val photo: List<PhotoModel>,
)

data class PhotoModel(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Long,
    val title: String,
    @SerializedName("ispublic")
    val isPublic: Long,
    @SerializedName("isFriend")
    val isFriend: Long,
    @SerializedName("isfamily")
    val isFamily: Long,
)
