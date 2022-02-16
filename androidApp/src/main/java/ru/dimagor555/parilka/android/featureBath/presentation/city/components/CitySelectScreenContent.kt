package ru.dimagor555.parilka.android.featureBath.presentation.city.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.dimagor555.parilka.android.featureBath.presentation.city.model.CityState

@Composable
fun CitySelectScreenContent(
    citiesStates: List<CityState>,
    onCityClick: (Int) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFe6ecf5)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(citiesStates) {
            CitySelectItem(it, onCityClick)
        }
    }
}