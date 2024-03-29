package ru.dimagor555.parilka.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigationFlow() {
    val startDestination = BathScreen.Welcome.route
    AppNavHost(startDestination = startDestination)
}

@Composable
private fun AppNavHost(startDestination: String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        registerAppFlow(navController)
    }
}

private fun NavGraphBuilder.registerAppFlow(navController: NavController) {
    registerBathFeatureFlow(navController)
}