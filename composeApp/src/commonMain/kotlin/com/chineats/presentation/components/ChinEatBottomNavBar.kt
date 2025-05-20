package com.chineats.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.chineats.Screen
import com.chineats.common.md_theme_dark_background
import com.chineats.common.md_theme_light_background

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun ChinEatBottomNavBar(navController: NavHostController) {
    val items = listOf(Screen.Home, Screen.Search, Screen.Favorite, Screen.Settings)
    val currentRoute = currentRoute(navController)
    NavigationBar(
        containerColor = if (isSystemInDarkTheme()) md_theme_dark_background else md_theme_light_background
    ) {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.route) },
                label = { Text(screen.route.replaceFirstChar { it.uppercase() }) },
                selected = currentRoute?.startsWith(screen.route) == true,
                onClick = {
                    navController.navigate(screen.route) {
                        navController.graph.findStartDestination().route?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = false // Only show label for selected item, Material 3 style
            )
        }
    }
}