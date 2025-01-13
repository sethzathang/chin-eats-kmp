package com.chineats.presentation.screens.favorite

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.chineats.presentation.components.ChinEatContent

@Composable
fun FavoriteScreen() {
    ChinEatContent(pageTitle = "Favorite") {
        Text(text = "Favorite Screen")
    }
}