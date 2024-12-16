package com.samvat.location.presentation.screens.places

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samvat.common.utils.navigation.events_and_result.PlacesResult
import com.samvat.location.domain.use_cases.SearchRestaurantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class PlaceSearchViewModel @Inject constructor(private val searchRestaurantsUseCase: SearchRestaurantsUseCase) :
    ViewModel() {

    private val _searchResult: MutableState<PlacesResult> = mutableStateOf<PlacesResult>(PlacesResult.Idle)
    val searchResult: State<PlacesResult> get() = _searchResult

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                searchRestaurants(it)
            }
        }
    }

    fun updateQuery(q: String) {
        _query.value = q

    }

    private fun searchRestaurants(query: String) =
        viewModelScope.launch {
            searchRestaurantsUseCase(query)
                .collectLatest {
                    Log.d("TAG", "searchRestaurants: ${it.list.size}")
                    _searchResult.value = it
                    Log.d("TAG", "searchResult: ${searchResult.value.location}")
                }
        }
}
