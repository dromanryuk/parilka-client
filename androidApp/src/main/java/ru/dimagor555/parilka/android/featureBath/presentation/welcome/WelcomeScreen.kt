package ru.dimagor555.parilka.android.featureBath.presentation.welcome

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.viewModel
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.components.WelcomeScreenContent

@Composable
fun WelcomeScreen(
    onContinueClick: () -> Unit,
    onCityClick: () -> Unit,
) {
    val viewModel by viewModel<WelcomeViewModel>()
    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier = Modifier,
        topBar = {  },
        content = { WelcomeScreenContent(state, onContinueClick, onCityClick) }
    )
}