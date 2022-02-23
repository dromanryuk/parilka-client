package ru.dimagor555.parilka.android.featureBath.presentation.overview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import ru.dimagor555.parilka.android.featureBath.presentation.overview.model.state.BathOfferState

@Composable
fun OverviewScreenContent(
    bathStates: List<BathOfferState>,
    onBathClick: () -> Unit,
    onFilterClick: () -> Unit,
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
                    style = MaterialTheme.typography.subtitle2
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
                        style = MaterialTheme.typography.body1
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = "Все бани Киева:",
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
        items(bathStates) {
            BathCard(it, modifier = Modifier.padding(10.dp), onBathClick = onBathClick)
        }
    }
}

