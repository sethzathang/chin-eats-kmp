package com.chineats.presentation.screens.home

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
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { ChinEatAppBar(pageTitle = "Home") }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home Screen")
            Button(
                onClick = { navController.navigate(Screen.HomeDetail.route) },
                content =  { Text(text = "Go to Home Detail") }
            )
        }
    }
}

@Composable
fun HomeDetailScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            ChinEatAppBar(
                pageTitle = "Home Details",
                backNavController = navController
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home Detail Screen")
        }
    }
}