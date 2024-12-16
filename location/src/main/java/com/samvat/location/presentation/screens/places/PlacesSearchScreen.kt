package com.samvat.location.presentation.screens.places

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.samvat.common.utils.navigation.events_and_result.PlacesResult


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PlacesSearchScreen(viewModel: PlaceSearchViewModel) {
    val permission = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )
    val placesResult by viewModel.searchResult
    val query by viewModel.query.collectAsState()

    if (permission.allPermissionsGranted) {

            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (searchCons, listCons) = createRefs()
                TextField(
                    value = query,
                    onValueChange = { viewModel.updateQuery(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(searchCons) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        })

                when (placesResult) {
                    is PlacesResult.Success -> {

                        LazyColumn(modifier = Modifier.constrainAs(listCons) {
                            top.linkTo(searchCons.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                            height = Dimension.fillToConstraints
                        }) {
                            items(placesResult.list) {

                                Text(
                                    text = it.getFullText(null).toString(),
                                    modifier = Modifier.padding(16.dp)
                                )

                            }

                        }
                    }

                    is PlacesResult.Error -> Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = (placesResult as PlacesResult.Error).message.toString())
                    }

                    PlacesResult.Idle -> {}
                    PlacesResult.Loading -> Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
    } else {
        LaunchedEffect(key1 = Unit) {
            permission.launchMultiplePermissionRequest()
        }
    }
}