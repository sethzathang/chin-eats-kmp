package com.chineats.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.chineats.data.LocalJsonRestaurantRepository
import com.chineats.domain.GetNearbyRestaurantsUseCase
import com.chineats.presentation.components.ChinEatContent

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeScreenViewModel = HomeScreenViewModel(
        getNearbyRestaurantsUseCase = GetNearbyRestaurantsUseCase(LocalJsonRestaurantRepository())
    )
) {
    val uiState by viewModel.uiState.collectAsState()
    ChinEatContent(pageTitle = "Restaurants") {
        LazyColumn(modifier = Modifier.padding(horizontal = 14.dp)) {
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
