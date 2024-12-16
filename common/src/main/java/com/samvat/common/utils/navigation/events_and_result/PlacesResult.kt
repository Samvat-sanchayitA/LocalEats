package com.samvat.common.utils.navigation.events_and_result

import android.location.Location
import com.google.android.libraries.places.api.model.AutocompletePrediction

sealed class PlacesResult(
    val location: Location? = null,
    val list : MutableList<AutocompletePrediction> = mutableListOf(),
    val message: String? = null,
) {
    class Success(location: Location, list : MutableList<AutocompletePrediction>) : PlacesResult(location, list)
    data object Loading:PlacesResult()
    data object Idle:PlacesResult()
    class Error(message: String) : PlacesResult(message = message)
}