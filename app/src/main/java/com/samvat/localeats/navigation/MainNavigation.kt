package com.samvat.localeats.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.samvat.common.utils.navigation.NestedNavigationRoute

@Composable
fun MainNavigation(navController: NavHostController, modifier: Modifier, navigationProvider: NavigationProvider) {
    NavHost(
        navController = navController,
        startDestination = NestedNavigationRoute.LOCATION.route
    ) {
       // navigationProvider.dashboardApi.registerGraph(navController, this)
        navigationProvider.locationFeatureApi.registerGraph(navController, this)
    }
}