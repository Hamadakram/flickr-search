package com.android.flickrsearch.data.mapper

import com.android.flickrsearch.domain.model.Photo
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PhotoMapperTest {

    private var photo: Photo? = null

    @Before
    fun setUp() {
        val mapper = PhotoMapper()
        photo = mapper.toDomainModel(PhotoMapperTestData.photoModel)
    }

    @Test
    fun `Verify that the image URL is built correctly`() {
        Assert.assertEquals(photo?.url, PhotoMapperTestData.url)
    }

    @Test
    fun `Verify that the mapped name matches the expected name`() {
        Assert.assertEquals(photo?.name, PhotoMapperTestData.name)
    }
}