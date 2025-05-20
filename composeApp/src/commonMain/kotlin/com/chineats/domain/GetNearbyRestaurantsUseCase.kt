package com.chineats.domain

import com.chineats.data.Restaurant
import com.chineats.data.RestaurantRepository

class GetNearbyRestaurantsUseCase(private val repository: RestaurantRepository) {
    suspend operator fun invoke(): List<Restaurant> = repository.getNearbyRestaurants()
} 