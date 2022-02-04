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
import androidx.compose.ui.unit.sp

@Composable
fun CostQuantityStatus() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "От 9999 грн/час",
            color = MaterialTheme.colors.onSurface,
            fontSize = 22.sp,
        )
        Text(
            text = "До 12 чел.",
            color = MaterialTheme.colors.onSurface.copy(0.5f),
            fontSize = 18.sp,
        )
    }
}