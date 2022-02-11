package ru.dimagor555.parilka.android.featureBath.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CostQuantityStatus(price: UInt, capacity: UByte) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "От $price грн/час",
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "До $capacity чел.",
            color = MaterialTheme.colors.onSurface.copy(0.5f),
            style = MaterialTheme.typography.body1
        )
    }
}