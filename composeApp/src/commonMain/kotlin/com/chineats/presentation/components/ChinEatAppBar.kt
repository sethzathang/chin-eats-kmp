package com.chineats.presentation.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

/**
 * @param pageTitle
 * @param backNavController - only pass in if you need to navigate back
 */
@Composable
fun ChinEatAppBar(
    pageTitle: String,
    backNavController: NavHostController? = null
) {
    if (backNavController != null) {
        TopAppBar(
            title = { Text(text = pageTitle) },
            backgroundColor = MaterialTheme.colors.background,
            navigationIcon = {
                IconButton(
                    onClick = { backNavController.popBackStack() },
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
            title = { Text(text = pageTitle) },
            backgroundColor = MaterialTheme.colors.background
        )
    }
}
