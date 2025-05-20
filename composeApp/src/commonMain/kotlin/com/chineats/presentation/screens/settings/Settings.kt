package com.chineats.presentation.screens.settings

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.chineats.Screen
import com.chineats.presentation.components.ChinEatContent
import androidx.compose.material3.Button as Material3Button
import androidx.compose.material3.Text as Material3Text

@Composable
fun SettingsScreen(navController: NavHostController) {
    ChinEatContent(pageTitle = "Settings") {
        Material3Button(
            onClick = { navController.navigate(Screen.HomeDetail.route) },
            content =  { Material3Text(text = "Go to Settings Detail") }
        )
    }
}

@Composable
fun SettingsDetailScreen(navController: NavHostController) {
    ChinEatContent(pageTitle = "Settings Details", navController = navController) {
        Material3Text(text = "Settings Detail Screen")
    }
}
