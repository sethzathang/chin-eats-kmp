package com.chineats

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chineats.common.CupcakeTheme
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
    CupcakeTheme { CupcakeApp() }
}

@Composable
fun CupcakeApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = { MainNavGraph(navController) }
    )
}

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Search.route) { SearchScreen() }
        composable(Screen.Favorite.route) { FavoriteScreen() }
        composable(Screen.Settings.route) { SettingsScreen(navController) }

        // Nested navigation for sub-screens
        composable(Screen.HomeDetail.route) { HomeDetailScreen(navController) }
        composable(Screen.SettingsDetail.route) { SettingsDetailScreen(navController) }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(Screen.Home, Screen.Search, Screen.Favorite, Screen.Settings)
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = null) },
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

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

sealed class Screen(val route: String, val icon: ImageVector) {
    data object Home : Screen("home", Icons.Default.Home)
    data object Search : Screen("search", Icons.Default.Search)
    data object Favorite : Screen("favorite", Icons.Default.Favorite)
    data object Settings : Screen("settings", Icons.Default.Settings)

    // Sub-screens
    data object HomeDetail : Screen("home/homeDetail", Icons.Default.Home)
    data object SettingsDetail : Screen("settings/settingsDetail", Icons.Default.Settings)
}
