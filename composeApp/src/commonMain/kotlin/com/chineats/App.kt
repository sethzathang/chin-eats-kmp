package com.chineats

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chineats.common.ChinEatsTheme
import com.chineats.presentation.components.ChinEatBottomNavBar
import com.chineats.presentation.screens.favorite.FavoriteScreen
import com.chineats.presentation.screens.home.HomeDetailScreen
import com.chineats.presentation.screens.home.HomeScreen
import com.chineats.presentation.screens.search.SearchScreen
import com.chineats.presentation.screens.settings.SettingsDetailScreen
import com.chineats.presentation.screens.settings.SettingsScreen

/**
 * Entry point of the application
 */
@Composable
fun App() {
    ChinEatsTheme {
        ChinEatsApp()
    }
}

@Composable
fun ChinEatsApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { ChinEatBottomNavBar(navController) },
        content = { MainNavGraph(navController) }
    )
}

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // Starting destinations
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Search.route) { SearchScreen() }
        composable(Screen.Favorite.route) { FavoriteScreen() }
        composable(Screen.Settings.route) { SettingsScreen(navController) }

        // Nested navigation for the sub-screens
        composable(Screen.HomeDetail.route) { HomeDetailScreen(navController) }
        composable(Screen.SettingsDetail.route) { SettingsDetailScreen(navController) }
    }
}

sealed class Screen(
    val route: String,
    val icon: ImageVector
) {
    // Starting destinations
    data object Home : Screen(route = "home", icon = Icons.Default.Home)
    data object Search : Screen(route = "search", icon = Icons.Default.Search)
    data object Favorite : Screen(route = "favorite", icon = Icons.Default.Favorite)
    data object Settings : Screen(route = "settings", icon = Icons.Default.Settings)

    // Sub-screens
    data object HomeDetail : Screen(route = "home/homeDetail", icon = Icons.Default.Home)
    data object SettingsDetail : Screen(route = "settings/settingsDetail", icon = Icons.Default.Settings)
}
