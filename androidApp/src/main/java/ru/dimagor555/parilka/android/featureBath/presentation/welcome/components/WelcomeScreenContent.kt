package ru.dimagor555.parilka.android.featureBath.presentation.welcome.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.dimagor555.parilka.android.featureBath.presentation.welcome.model.WelcomeStore

@Composable
fun WelcomeScreenContent(
    state: WelcomeStore.State,
    onContinueClick: () -> Unit,
    onCityClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        AppTitle()
        CitySelect(state, onContinueClick, onCityClick)
    }
}

@Composable
fun AppTitle() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "PARILKA",
            style = MaterialTheme.typography.h1
        )
        Text(
            text = "Все бани и сауны",
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun CitySelect(
    state: WelcomeStore.State,
    onContinueClick: () -> Unit,
    onCityClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
            text = "А каком городе вы находитесь?",
            style = MaterialTheme.typography.h2
        )
        DefaultWelcomeButton(onContinueClick, state.cityState)
        DefaultWelcomeButton(onCityClick, "Другой город")
    }
}