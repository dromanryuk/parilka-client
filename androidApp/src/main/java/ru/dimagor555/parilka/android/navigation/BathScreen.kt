package ru.dimagor555.parilka.android.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import ru.dimagor555.parilka.android.featureBath.presentation.bath.BathScreen
import ru.dimagor555.parilka.android.featureBath.presentation.city.CitySelectScreen
import ru.dimagor555.parilka.android.featureBath.presentation.filter.FilterScreen
import ru.dimagor555.parilka.android.featureBath.presentation.overview.OverviewScreen
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.WelcomeScreen

object BathScreen {
    object Overview : Screen("BathOverview")
    object Bath: Screen("BathDetails")
    object Filter: Screen("BathFilter")
    object City: Screen("SelectCity")
    object Welcome: Screen("AppWelcome")
}

fun NavGraphBuilder.registerBathFeatureFlow(navController: NavController) {
    registerScreen(BathScreen.Overview) {
        OverviewScreen(
            onBathClick = { navController.navigate(BathScreen.Bath.route) },
            onFilterClick = { navController.navigate(BathScreen.Filter.route) },
            onCityClick = { navController.navigate(BathScreen.City.route) }
        )
    }
    registerScreen(BathScreen.Bath) {
        BathScreen(
            bathId = 1,
            onBackClick = { navController.navigate(BathScreen.Overview.route) }
        )
    }
    registerScreen(BathScreen.Filter) {
        FilterScreen(
            onBackClick = { navController.navigate(BathScreen.Overview.route) }
        )
    }
    registerScreen(BathScreen.City) {
        CitySelectScreen(
            onBackClick = { navController.popBackStack() },
            onCitySelectClick = { navController.navigate(BathScreen.Overview.route) }
        )
    }
    registerScreen(BathScreen.Welcome) {
        WelcomeScreen(
            onContinueClick = { navController.navigate(BathScreen.Overview.route) },
            onCityClick = { navController.navigate(BathScreen.City.route) }
        )
    }
}
