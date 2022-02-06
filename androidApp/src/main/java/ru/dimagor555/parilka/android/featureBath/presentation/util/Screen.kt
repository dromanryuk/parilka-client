package ru.dimagor555.parilka.android.featureBath.presentation.util

sealed class Screen(val route: String) {
    object Overview: Screen("OverviewScreen")
    object Bath: Screen("BathScreen")
    object Filter: Screen("FilterScreen")
}