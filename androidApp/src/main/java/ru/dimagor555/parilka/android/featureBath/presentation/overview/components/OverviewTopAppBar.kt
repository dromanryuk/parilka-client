package ru.dimagor555.parilka.android.featureBath.presentation.overview.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.LocationCity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun OverviewTopAppBar(
    cityName: String,
    onCitySelectClick: () -> Unit,
    onSettingsClick: () -> Unit,
) {
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
            Image(
                painter = rememberGlidePainter("https://ekaterinburg.spravka.city/public_files/company/logo/1395/logo-555298-ekaterinburg.png"),
                contentDescription = "bath"
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier
                        .clickable { onCitySelectClick() },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(5.dp),
                        imageVector = Icons.Rounded.LocationCity,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onSurface.copy(0.5f)
                    )
                    Text(
                        modifier = Modifier
                            .padding(end = 5.dp),
                        text = cityName,
                        style = MaterialTheme.typography.body1
                    )
                }
                IconButton(
                    onClick = { onSettingsClick() }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onSurface.copy(0.5f)
                    )
                }
            }
        }
    }
}