package com.samvat.common.utils.navigation

enum  class NestedNavigationRoute(val route: String)  {
    DASHBOARD("dashboard"),
    LOCATION("location"),
}

enum class DashboardNavigationRoute(val route: String) {
    HOME_SCREEN("home_screen")
}

enum class LocationNavigationRoute(val route: String) {
    PLACES_SEARCH("places"),
    GOOGLE_MAPS("google_maps")
}