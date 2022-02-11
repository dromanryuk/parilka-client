package ru.dimagor555.parilka.android.featureBath.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailsButtons(onBathClick: () -> Unit, phoneNumber: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        DetailsButton(phoneNumber, MaterialTheme.colors.onSurface, Color(0xFFdedffd), Modifier.weight(1f), {})
        DetailsButton("Подробнее", MaterialTheme.colors.surface, Color(0xFF004dff), Modifier.weight(1f), onBathClick)
    }
}

@Composable
fun DetailsButton(text: String, fontColor: Color, backgroundColor: Color, modifier: Modifier, onBathClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = { onBathClick() },
        shape = RoundedCornerShape(50.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = fontColor
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}