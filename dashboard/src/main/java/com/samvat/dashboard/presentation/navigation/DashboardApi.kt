package com.samvat.dashboard.presentation.navigation

import com.samvat.common.utils.navigation.FeatureApi


interface DashboardApi : FeatureApi {

}
class DashboardApiImpl : DashboardApi  {
    override fun registerGraph(
        navHost: androidx.navigation.NavHostController,
        navGraphBuilder: androidx.navigation.NavGraphBuilder
    ) {
          InternalDashboardApi.registerGraph(navHost, navGraphBuilder)
    }
}