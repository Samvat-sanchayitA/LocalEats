package com.samvat.location.domain.repository

import android.location.Location
import com.samvat.common.utils.navigation.events_and_result.PlacesResult
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun getLocationOnce(location: (Location) -> Unit)
    fun searchRestaurants(query: String): Flow<PlacesResult>
}