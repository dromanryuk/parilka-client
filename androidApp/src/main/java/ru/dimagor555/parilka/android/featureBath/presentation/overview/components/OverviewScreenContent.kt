package ru.dimagor555.parilka.android.featureBath.presentation.overview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.sp

@Composable
fun OverviewScreenContent(
    onBathClick: () -> Unit,
    onFilterClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFe6ecf5)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    modifier = Modifier.padding(),
                    text = "Воспользуйтесь удобным фильтром для поиска",
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 22.sp,
                )
                Button(
                    onClick = { onFilterClick() },
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF2772e7),
                        contentColor = MaterialTheme.colors.surface
                    )
                ) {
                    Text(
                        text = "Выбрать фильтры поиска",
                        fontSize = 16.sp,
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = "Все бани Киева:",
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 22.sp,
                )
            }
        }
        item {
            BathCard(modifier = Modifier.padding(10.dp), onBathClick = onBathClick)
        }
        item {
            BathCard(modifier = Modifier.padding(10.dp), onBathClick = onBathClick)
        }
    }
}

