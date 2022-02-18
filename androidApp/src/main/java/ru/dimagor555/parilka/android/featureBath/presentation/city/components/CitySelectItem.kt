package ru.dimagor555.parilka.android.featureBath.presentation.city.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.dimagor555.parilka.android.featureBath.presentation.city.model.CityState

@Composable
fun CitySelectItem(
    state: CityState,
    onCityClick: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFe6ecf5))
            .clickable { onCityClick(state.id) }
    ) {
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 5.dp, top = 10.dp),
            text = state.name,
            style = MaterialTheme.typography.h2
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 5.dp, bottom = 10.dp),
            text = state.country,
            style = MaterialTheme.typography.caption
        )
    }
}