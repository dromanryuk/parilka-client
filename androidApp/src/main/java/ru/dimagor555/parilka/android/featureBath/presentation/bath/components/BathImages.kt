package ru.dimagor555.parilka.android.featureBath.presentation.bath.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.glide.rememberGlidePainter
import ru.dimagor555.parilka.android.featureBath.presentation.components.DefaultIconButton

@Composable
fun BathImages(imageUrls: Set<String>) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        if (imageUrls.isNotEmpty()) {
            Image(
                painter = rememberGlidePainter(imageUrls.first()),
                contentDescription = "bath"
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                DefaultIconButton(
                    image = Icons.Filled.KeyboardArrowLeft,
                    color = MaterialTheme.colors.surface.copy(0.7f),
                    onClick = {}
                )
                DefaultIconButton(
                    image = Icons.Filled.KeyboardArrowRight,
                    color = MaterialTheme.colors.surface.copy(0.7f),
                    onClick = {}
                )
            }
        }
    }
}