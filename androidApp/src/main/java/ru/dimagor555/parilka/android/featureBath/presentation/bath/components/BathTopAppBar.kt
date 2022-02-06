package ru.dimagor555.parilka.android.featureBath.presentation.bath.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.glide.rememberGlidePainter
import ru.dimagor555.parilka.android.featureBath.presentation.components.DefaultAppBarButton

@Composable
fun BathTopAppBar(onBackClick: () -> Unit) {
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
            Image(
                painter = rememberGlidePainter("https://ekaterinburg.spravka.city/public_files/company/logo/1395/logo-555298-ekaterinburg.png"),
                contentDescription = "bath"
            )
            DefaultAppBarButton(
                fontColor = MaterialTheme.colors.onSurface.copy(0.5f),
                backgroundColor = Color(0xFFd6d5e2),
                onClick = {  }
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Настройки",
                        style = MaterialTheme.typography.button
                    )
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onSurface.copy(0.5f)
                    )
                }
            }
        }
    }
}