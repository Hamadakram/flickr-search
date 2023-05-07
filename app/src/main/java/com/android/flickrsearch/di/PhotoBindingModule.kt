package com.android.flickrsearch.di

import com.android.flickrsearch.data.PhotoRepositoryImpl
import com.android.flickrsearch.domain.PhotoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class PhotoBindingModule {
    @Binds
    abstract fun bindPhotoRepository(photoRepositoryImpl: PhotoRepositoryImpl): PhotoRepository
}