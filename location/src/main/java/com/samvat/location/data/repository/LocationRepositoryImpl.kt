package com.samvat.location.data.repository

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.LocationRestriction
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.samvat.common.utils.navigation.events_and_result.PlacesResult
import com.samvat.location.domain.repository.LocationRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

@SuppressLint("MissingPermission")
class LocationRepositoryImpl @Inject constructor(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val placesClient: PlacesClient
) : LocationRepository {
    private var currentLocation: LatLng = LatLng(0.0, 0.0)
    private val token = AutocompleteSessionToken.newInstance()


    override fun getLocationOnce(location: (Location) -> Unit) {
        val locationRequest =
            LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 100).setIntervalMillis(1000)
                .setMaxUpdates(1).build()
        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                p0.locations[0]?.let {
                    currentLocation = LatLng(it.latitude, it.longitude)
                    location.invoke(it)
                }
            }
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null)
    }

    override fun searchRestaurants(query: String): Flow<PlacesResult> = callbackFlow {
        getLocationOnce { location ->
            val request =
                FindAutocompletePredictionsRequest.builder()
                    .setSessionToken(token)
                    .setOrigin(LatLng(location.latitude, location.longitude))
                    .setCountries(mutableListOf("US"))
                    .setQuery(query)
                    .setTypesFilter(listOf("restaurant"))
                    .setLocationRestriction(findLocationRestriction(location))
                    .build()

            placesClient.findAutocompletePredictions(request).addOnSuccessListener {
                Log.d("TAG", "searchRestaurants in Repo: ${it.autocompletePredictions.size}")
                trySend(PlacesResult.Success(location, list = it.autocompletePredictions))
            }.addOnFailureListener {
                trySend(PlacesResult.Error(it.message.toString()))

            }
        }

        awaitClose {

        }
    }

    private fun findLocationRestriction(location: Location): LocationRestriction {
        return RectangularBounds.newInstance(
            LatLng(location.latitude - 0.2, location.longitude - 0.2),
            LatLng(location.latitude + 0.2, location.longitude + 0.2)
        )
    }

    fun getCurrentLocation(): LatLng = currentLocation
}