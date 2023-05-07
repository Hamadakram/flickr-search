package com.android.flickrsearch.data.mapper

import com.android.flickrsearch.data.model.PhotoModel

object PhotoMapperTestData {
    // Provided
    val photoModel = PhotoModel(
        id = "52870617423",
        owner = "105411217@N03",
        secret = "7e3317c86d",
        server = "65535",
        farm = 66,
        title = "17 ABR",
        isPublic = 1,
        isFriend = 0,
        isFamily = 0
    )

    // Expected
    const val url = "https://live.staticflickr.com/65535/52870617423_7e3317c86d.jpg"
    const val name = "17 ABR"
}