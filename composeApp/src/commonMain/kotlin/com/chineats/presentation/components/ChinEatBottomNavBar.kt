package com.chineats.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.chineats.Screen

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun ChinEatBottomNavBar(navController: NavHostController) {
    val items = listOf(Screen.Home, Screen.Search, Screen.Favorite, Screen.Settings)
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = screen.route) },
                selected = currentRoute(navController)?.startsWith(screen.route) == true,
                onClick = {
                    navController.navigate(screen.route) {
                        navController.graph.findStartDestination().route?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}