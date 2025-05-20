package com.chineats.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

/**
 * Common scrollable content
 *
 * @param pageTitle - page title
 * @param navController - only pass in if you need to navigate back
 * @param content - composable content
 */
@Composable
fun ChinEatContent(
    pageTitle: String,
    navController: NavHostController? = null,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            ChinEatAppBar(
                pageTitle = pageTitle,
                navController = navController
            )
        },
        content = { contentPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                content()
            }
        }
    )
}