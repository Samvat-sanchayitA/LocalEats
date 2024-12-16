package com.samvat.location.domain.di

import com.samvat.location.domain.repository.LocationRepository
import com.samvat.location.domain.use_cases.SearchRestaurantsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {
    @Provides
    fun provideSearchRestaurantsUseCase(locationRepository: LocationRepository): SearchRestaurantsUseCase {

        return SearchRestaurantsUseCase(locationRepository)
    }
}