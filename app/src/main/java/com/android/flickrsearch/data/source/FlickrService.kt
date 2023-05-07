package com.android.flickrsearch.data.source

import com.android.flickrsearch.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrService {
    @GET("rest/?method=flickr.photos.search")
    suspend fun search(@Query("text") query: String): SearchResponse
}