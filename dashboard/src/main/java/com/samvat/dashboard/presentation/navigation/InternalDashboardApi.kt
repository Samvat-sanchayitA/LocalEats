package com.samvat.dashboard.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.samvat.common.utils.navigation.DashboardNavigationRoute
import com.samvat.common.utils.navigation.FeatureApi
import com.samvat.common.utils.navigation.NestedNavigationRoute
import com.samvat.dashboard.presentation.screens.home.HomeScreen

object InternalDashboardApi : FeatureApi {
    override fun registerGraph(navHost: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = DashboardNavigationRoute.HOME_SCREEN.route,
            route = NestedNavigationRoute.DASHBOARD.route
        )
        {
            composable(route =DashboardNavigationRoute.HOME_SCREEN.route) {
                HomeScreen()
            }
        }
    }
}