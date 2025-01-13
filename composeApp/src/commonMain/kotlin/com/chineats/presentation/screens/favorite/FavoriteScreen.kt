package com.chineats.presentation.screens.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.chineats.presentation.components.ChinEatAppBar

@Composable
fun FavoriteScreen() {
    Scaffold(
        topBar = { ChinEatAppBar(pageTitle = "Favorite") }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Favorite Main Screen")
        }
    }
}