package com.chineats.data

data class Restaurant(
    val id: String,
    val name: String,
    val address: String,
    val distanceMile: Int,
    val imageUrl: String,
    val rating: Double,
    val reviewCount: Int
) 