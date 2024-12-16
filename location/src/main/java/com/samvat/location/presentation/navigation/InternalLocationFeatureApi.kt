package com.samvat.location.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.samvat.common.utils.navigation.FeatureApi
import com.samvat.common.utils.navigation.LocationNavigationRoute
import com.samvat.common.utils.navigation.NestedNavigationRoute
import com.samvat.location.presentation.screens.google_mpas.GoogleMapScreen
import com.samvat.location.presentation.screens.places.PlaceSearchViewModel
import com.samvat.location.presentation.screens.places.PlacesSearchScreen


object InternalLocationFeatureApi : FeatureApi {
    override fun registerGraph(navHost: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = LocationNavigationRoute.PLACES_SEARCH.route,
            route = NestedNavigationRoute.LOCATION.route
        ) {
            composable(LocationNavigationRoute.PLACES_SEARCH.route) {
                val viewModel = hiltViewModel<PlaceSearchViewModel>()
                PlacesSearchScreen(viewModel)
            }

            composable(LocationNavigationRoute.GOOGLE_MAPS.route) {
                GoogleMapScreen()
            }

        }
    }
}