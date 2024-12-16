package com.samvat.location.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.samvat.common.utils.navigation.FeatureApi

interface LocationFeatureApi : FeatureApi {
}

class LocationFeatureApiImpl : LocationFeatureApi {
    override fun registerGraph(
        navHost: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
       InternalLocationFeatureApi.registerGraph(navHost, navGraphBuilder)
    }

}