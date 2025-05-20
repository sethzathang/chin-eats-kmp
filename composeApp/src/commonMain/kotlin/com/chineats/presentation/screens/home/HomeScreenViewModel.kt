package com.chineats.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chineats.domain.GetNearbyRestaurantsUseCase
import com.chineats.data.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getNearbyRestaurantsUseCase: GetNearbyRestaurantsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeViewState())
    val uiState: StateFlow<HomeViewState> = _uiState.asStateFlow()

    data class HomeViewState (
        val restaurants: List<Restaurant> = emptyList()
    )

    init {
        viewModelScope.launch {
            val restaurants = getNearbyRestaurantsUseCase()
            _uiState.value = HomeViewState(restaurants = restaurants)
        }
    }
}
