package com.chineats.presentation.screens.settings

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.chineats.Screen
import com.chineats.presentation.components.ChinEatContent

@Composable
fun SettingsScreen(navController: NavHostController) {
    ChinEatContent(pageTitle = "Settings") {
        Button(
            onClick = { navController.navigate(Screen.HomeDetail.route) },
            content =  { Text(text = "Go to Settings Detail") }
        )
    }
}

@Composable
fun SettingsDetailScreen(navController: NavHostController) {
    ChinEatContent(pageTitle = "Settings Details", navController = navController) {
        Text(text = "Settings Detail Screen")
    }
}
