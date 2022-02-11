package ru.dimagor555.parilka.android.featureBath.presentation.bath.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.dimagor555.parilka.android.featureBath.presentation.bath.model.state.BathContentState

@Composable
fun BathScreenContent(bathState: BathContentState) {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state)
            .background(Color(0xFFe6ecf5)),
    ) {
        BathName(bathState.name)
        BathImages(bathState.imageUrls)

        BathFullDescription(
            bathState.bathRentTerms.minPrice,
            bathState.bath.capacity,
            bathState.phoneNumber,
            bathState.bath.location.district,
            bathState.bath.location.address,
            bathState.bath.location.subwayStation,
            bathState.bath.bathTypes,
            bathState.bath.servicesByTypes,
            bathState.bathRentTerms.minRentHours,
            bathState.bathRentTerms.priceNames,
            bathState.description
        )
    }
}

@Composable
private fun BathName(name: String) {
    Text(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp, top = 20.dp),
        text = name,
        style = MaterialTheme.typography.subtitle1
    )
}
