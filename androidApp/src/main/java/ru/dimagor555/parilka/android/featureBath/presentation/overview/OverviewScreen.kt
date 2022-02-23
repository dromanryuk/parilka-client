package ru.dimagor555.parilka.android.featureBath.presentation.overview

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.viewModel
import ru.dimagor555.parilka.android.featureBath.presentation.overview.components.OverviewScreenContent
import ru.dimagor555.parilka.android.featureBath.presentation.overview.components.OverviewTopAppBar

@Composable
fun OverviewScreen(
    onBathClick: () -> Unit,
    onFilterClick: () -> Unit,
    onCityClick: () -> Unit,
) {
    val viewModel by viewModel<BathOverviewViewModel>()
    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier = Modifier,
        topBar = {
            OverviewTopAppBar(
                cityName = state.cityName,
                onCitySelectClick = onCityClick,
                onSettingsClick = {}
            )
        },
        content = {
            OverviewScreenContent(
                bathStates = state.bathStates,
                onBathClick = onBathClick,
                onFilterClick = onFilterClick,
            )
        }
    )
}