package com.samvat.dashboard.presentation.di

import com.samvat.dashboard.presentation.navigation.DashboardApi
import com.samvat.dashboard.presentation.navigation.DashboardApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object PresentationModule {

    @Provides

    fun provideDashboardApi(): DashboardApi {
        return DashboardApiImpl()

    }
}