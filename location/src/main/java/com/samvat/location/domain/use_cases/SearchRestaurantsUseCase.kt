package com.samvat.location.domain.use_cases

import com.samvat.location.domain.repository.LocationRepository
import javax.inject.Inject

class SearchRestaurantsUseCase @Inject constructor(private val locationRepository: LocationRepository) {
   operator fun invoke(query:String) = locationRepository.searchRestaurants(query)
}