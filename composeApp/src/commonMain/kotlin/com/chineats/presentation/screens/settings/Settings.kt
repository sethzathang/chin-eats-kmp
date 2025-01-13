package com.chineats.presentation.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import com.chineats.Screen
import com.chineats.presentation.components.ChinEatAppBar

@Composable
fun SettingsScreen(navController: NavHostController) {
    Scaffold(
        topBar = { ChinEatAppBar(pageTitle = "Setting") }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Setting Screen")
            Button(
                onClick = { navController.navigate(Screen.SettingsDetail.route) },
                content =  { Text(text = "Go to Setting Detail") }
            )
        }
    }
}

@Composable
fun SettingsDetailScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            ChinEatAppBar(
                pageTitle = "Settings Detail",
                backNavController = navController
            )
        }
    ) {
        Column {
            Text(text = "Settings Detail Screen")
        }
    }
}
