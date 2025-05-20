package com.chineats.presentation.components

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

/**
 * Common App Bar
 *
 * @param pageTitle
 * @param navController - only pass in if you need to navigate back
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChinEatAppBar(
    pageTitle: String,
    navController: NavHostController? = null
) {
    if (navController != null) {
        TopAppBar(
            modifier = Modifier.statusBarsPadding(),
            title = { Text(text = pageTitle) },
            navigationIcon = {
                IconButton(
                    onClick = { navController.popBackStack() },
                    content = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back button"
                        )
                    }
                )
            }
        )
    } else {
        TopAppBar(
            modifier = Modifier.statusBarsPadding(),
            title = { Text(text = pageTitle) },
        )
    }
}
