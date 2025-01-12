package com.chineats

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chineats.presentation.OrderSummaryScreen
import com.chineats.presentation.OrderViewModel
import com.chineats.presentation.SelectOptionScreen
import com.chineats.presentation.StartOrderScreen

/**
 * enum values that represent the screens in the app
 */
enum class ScreenTitle(
    val title: String
) {
    Start(title = "Start"),
    Flavor(title = "Flavor"),
    Summary(title = "Summary")
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar(
    currentScreen: ScreenTitle,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    TopAppBar(
        title = { Text(currentScreen.title) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = ""
                    )
                }
            }
        }
    )
}

@Composable
fun CupcakeApp(
    viewModel: OrderViewModel = viewModel { OrderViewModel() },
    navController: NavHostController = rememberNavController()
) {
    // get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // get the name of the current screen
    val currentScreen = ScreenTitle.valueOf(
        value = backStackEntry?.destination?.route ?: ScreenTitle.Start.name
    )
    Scaffold(
        topBar = {
            CupcakeAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
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
