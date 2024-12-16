package com.samvat.localeats.di

import com.samvat.dashboard.presentation.navigation.DashboardApi
import com.samvat.localeats.navigation.NavigationProvider
import com.samvat.location.presentation.navigation.LocationFeatureApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideNavigationProvider(dashboardApi: DashboardApi, locationFeatureApi: LocationFeatureApi): NavigationProvider {
        return NavigationProvider(dashboardApi, locationFeatureApi)
    }
}