package ru.dimagor555.parilka.android.featureBath.presentation.city.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.dimagor555.parilka.android.featureBath.presentation.components.DefaultAppBarButton

@Composable
fun CitySelectTopAppBar(onBackClick: () -> Unit) {
    TopAppBar(
        backgroundColor = Color(0xFFe6ecf5),
        elevation = 0.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {
            DefaultAppBarButton(
                fontColor = MaterialTheme.colors.surface,
                backgroundColor = Color(0xFF4864ce),
                onClick = onBackClick
            ) {
                Text(
                    text = "Назад к поиску",
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}