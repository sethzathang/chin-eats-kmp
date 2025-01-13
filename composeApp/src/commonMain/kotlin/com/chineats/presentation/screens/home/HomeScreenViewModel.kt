package com.chineats.presentation.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeViewState(""))
    val uiState: StateFlow<HomeViewState> = _uiState.asStateFlow()

    fun setQuantity(numberCupcakes: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                test = numberCupcakes.toString()
            )
        }
    }

    data class HomeViewState (
        val test: String
    )
}
