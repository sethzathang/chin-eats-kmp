package com.chineats.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.chineats.presentation.components.ChinEatContent
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.chineats.domain.GetNearbyRestaurantsUseCase
import com.chineats.data.LocalJsonRestaurantRepository

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeScreenViewModel = HomeScreenViewModel(
        getNearbyRestaurantsUseCase = GetNearbyRestaurantsUseCase(LocalJsonRestaurantRepository())
    )
) {
    val uiState by viewModel.uiState.collectAsState()
    ChinEatContent(pageTitle = "Restaurants") {
        LazyColumn {
            items(uiState.restaurants) { restaurant ->
                RestaurantListItem(restaurant = restaurant)
            }
        }
    }
}

@Composable
fun HomeDetailScreen(navController: NavHostController) {
    ChinEatContent(pageTitle = "Restaurant Details", navController = navController) {
        Text(text = "Home Detail Screen")
    }
}
