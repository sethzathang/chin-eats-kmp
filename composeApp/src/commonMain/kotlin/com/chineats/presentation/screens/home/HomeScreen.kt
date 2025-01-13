package com.chineats.presentation.screens.home

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.chineats.Screen
import com.chineats.presentation.components.ChinEatContent

@Composable
fun HomeScreen(navController: NavHostController) {
    ChinEatContent(pageTitle = "Restaurants") {
        Button(
            onClick = { navController.navigate(Screen.HomeDetail.route) },
            content =  { Text(text = "Go to Home Detail") }
        )
    }
}

@Composable
fun HomeDetailScreen(navController: NavHostController) {
    ChinEatContent(pageTitle = "Restaurant Details", navController = navController) {
        Text(text = "Home Detail Screen")
    }
}
