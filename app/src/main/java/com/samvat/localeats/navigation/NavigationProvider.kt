package com.samvat.localeats.navigation

import com.samvat.dashboard.presentation.navigation.DashboardApi
import com.samvat.location.presentation.navigation.LocationFeatureApi

data class NavigationProvider(
    val dashboardApi: DashboardApi,
    val locationFeatureApi: LocationFeatureApi
)
