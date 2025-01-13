package com.chineats

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chineats.common.CupcakeTheme
import com.chineats.presentation.OrderSummaryScreen
import com.chineats.presentation.OrderViewModel
import com.chineats.presentation.SelectOptionScreen
import com.chineats.presentation.StartOrderScreen

/**
 * Entry point of the application
 */
@Composable
fun App() {
    CupcakeTheme { CupcakeApp() }
}

/**
 * enum values that represent the screens in the app
 */
enum class ScreenTitle(val title: String) {
    Start(title = "Start"),
    Flavor(title = "Flavor"),
    Summary(title = "Summary")
}

@Composable
fun CupcakeApp(
    viewModel: OrderViewModel = viewModel { OrderViewModel() },
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = ScreenTitle.valueOf(
        value = backStackEntry?.destination?.route ?: ScreenTitle.Start.name
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = currentScreen.title) },
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "back arrow"
                            )
                        }
                    }
                }
            )
        },
        content = {
            NavHost(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                startDestination = ScreenTitle.Start.name
            ) {
                composable(route = ScreenTitle.Start.name) {
                    StartOrderScreen(
                        onNavigateToSummary = {
                            navController.navigate(ScreenTitle.Summary.name)
                        }
                    )
                }
                composable(route = ScreenTitle.Flavor.name) {
                    SelectOptionScreen(
                        onClickBackButton = {
                            popBackToStart(navController)
                        }
                    )
                }
                composable(route = ScreenTitle.Summary.name) {
                    OrderSummaryScreen(
                        onClickBackButton = {
                            popBackToStart(navController)
                        }
                    )
                }
            }
        }
    )
}

/**
 * Pops up to [ScreenTitle.Start]
 */
private fun popBackToStart(
    navController: NavHostController
) {
    navController.popBackStack(
        route = ScreenTitle.Start.name,
        inclusive = false
    )
}
