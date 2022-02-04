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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun BathImage() {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = rememberGlidePainter("https://baniaisauna.ru/wp-content/uploads/YF3UeP2D90OX3nj5FqXDqoKFTzAZx4xD9pustwkY.jpeg"),
            contentDescription = "bath"
        )
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "Плакучая Ива",
                color = MaterialTheme.colors.surface,
                fontSize = 20.sp,
            )
            Text(
                text = "обл: Киевская, пос. Козин. ул. Лбуховское шоссе, 55",
                color = MaterialTheme.colors.surface,
                fontSize = 10.sp,
            )
        }
    }
}