package ru.dimagor555.parilka.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import ru.dimagor555.parilka.android.featureBath.presentation.bath.BathScreen
import ru.dimagor555.parilka.android.featureBath.presentation.filter.FilterScreen
import ru.dimagor555.parilka.android.featureBath.presentation.overview.OverviewScreen
import ru.dimagor555.parilka.android.featureBath.presentation.util.Screen
import ru.dimagor555.parilka.android.featureBath.ui.theme.ParilkaTheme

@ExperimentalAnimationApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParilkaTheme {
                val navController = rememberAnimatedNavController()
                NavGraph(navController)
            }
        }
    }

    @Composable
    fun NavGraph(navController: NavHostController) {
        AnimatedNavHost(
            navController = navController,
            startDestination = Screen.Overview.route,
        ) {
            composable(
                Screen.Overview.route,
            ) {
                OverviewScreen(
                    onBathClick = { navController.navigate(Screen.Bath.route) },
                    onFilterClick = { navController.navigate(Screen.Filter.route) },
                )
            }
            composable(
                Screen.Bath.route,
            ) {
                BathScreen(
                    onBackClick = { navController.navigate(Screen.Overview.route) }
                )
            }
            composable(
                Screen.Filter.route,
            ) {
                FilterScreen(
                    onBackClick = { navController.navigate(Screen.Overview.route) }
                )
            }
        }
    }
}


