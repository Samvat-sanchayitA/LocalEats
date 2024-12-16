package com.samvat.location.presentation.di

import com.samvat.location.presentation.navigation.LocationFeatureApi
import com.samvat.location.presentation.navigation.LocationFeatureApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object PresentationModule {

    @Provides
    fun provideLocationFeatureApi(): LocationFeatureApi {
        return LocationFeatureApiImpl()
    }

}