package com.samvat.common.utils.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureApi {
    fun registerGraph(navHost: NavHostController, navGraphBuilder: NavGraphBuilder)
}