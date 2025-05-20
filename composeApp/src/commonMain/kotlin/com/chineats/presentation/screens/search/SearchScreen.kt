package com.chineats.presentation.screens.search

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.chineats.presentation.components.ChinEatContent

@Composable
fun SearchScreen() {
    ChinEatContent(pageTitle = "Search") {
        Text(text = "Search Screen")
    }
}