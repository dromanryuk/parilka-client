package ru.dimagor555.parilka.android.featureBath.presentation.overview.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun BathImage(
    img: Set<String>,
    name: String,
    address: String,
    district: String?
) {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = rememberGlidePainter(img.first()),
            contentDescription = "bathImg"
        )
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = name,
                color = if (img.isEmpty()) MaterialTheme.colors.onSurface else MaterialTheme.colors.surface,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = "$district $address",
                color = if (img.isEmpty()) MaterialTheme.colors.onSurface else MaterialTheme.colors.surface,
                style = MaterialTheme.typography.caption
            )
        }
    }
}