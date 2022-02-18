package ru.dimagor555.parilka.android.featureBath.presentation.city

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.viewModel
import ru.dimagor555.parilka.android.featureBath.presentation.city.components.CitySelectScreenContent
import ru.dimagor555.parilka.android.featureBath.presentation.city.components.CitySelectTopAppBar
import ru.dimagor555.parilka.android.featureBath.presentation.city.model.CitySelectStore

@Composable
fun CitySelectScreen(
    onBackClick: () -> Unit,
    onCitySelectClick: () -> Unit,
) {
    val viewModel by viewModel<CitySelectViewModel>()
    val state by viewModel.state.collectAsState()

    val sendAction = viewModel::sendAction

    Scaffold(
        modifier = Modifier,
        topBar = { CitySelectTopAppBar(onBackClick) },
        content = {
            CitySelectScreenContent(
                citiesStates = state.citiesState,
                onCityClick = {
                    onCitySelectClick()
                    sendAction(CitySelectStore.Action.SaveCityIdInSettings(it))
                }
            )
        }
    )
}