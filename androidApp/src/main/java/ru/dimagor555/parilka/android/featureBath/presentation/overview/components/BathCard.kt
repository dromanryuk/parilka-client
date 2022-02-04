package ru.dimagor555.parilka.android.featureBath.presentation.overview.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BathCard(
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
            BathImage()
            BathDescription(onBathClick)
        }
    }
}