package ru.dimagor555.parilka.android.featureBath.presentation.overview.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.state.BathOfferState

@Composable
fun BathCard(
    state: BathOfferState,
    modifier: Modifier,
    onBathClick: () -> Unit
) {
    Card(
        modifier = modifier,
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BathImage(
                img = state.imageUrls,
                name = state.name,
                address = state.bath.location.address,
                district = state.bath.location.district)
            BathDescription(
                onBathClick,
                price = state.price,
                capacity = state.bath.capacity,
                subwayStation = state.bath.location.subwayStation,
                servicesByTypes = state.bath.servicesByTypes,
                bathTypes = state.bath.bathTypes,
                phoneNumber = state.phoneNumber
            )
        }
    }
}