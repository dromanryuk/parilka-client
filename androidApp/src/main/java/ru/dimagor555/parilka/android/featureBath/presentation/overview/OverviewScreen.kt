package ru.dimagor555.parilka.android.featureBath.presentation.overview

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.dimagor555.parilka.android.featureBath.presentation.overview.components.OverviewScreenContent
import ru.dimagor555.parilka.android.featureBath.presentation.overview.components.OverviewTopAppBar

@Composable
fun OverviewScreen(
    onBathClick: () -> Unit,
    onFilterClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = { OverviewTopAppBar() },
        content = { OverviewScreenContent(onBathClick, onFilterClick) }
    )
}