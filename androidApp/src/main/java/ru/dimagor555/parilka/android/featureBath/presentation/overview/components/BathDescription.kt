package ru.dimagor555.parilka.android.featureBath.presentation.overview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import ru.dimagor555.parilka.android.featureBath.presentation.components.BathLocation
import ru.dimagor555.parilka.android.featureBath.presentation.components.CostQuantityStatus
import ru.dimagor555.parilka.android.featureBath.presentation.components.DetailsButtons

@Composable
fun BathDescription(onBathClick: () -> Unit) {
    Column(
        modifier = Modifier.padding(8.dp),
    ) {
        CostQuantityStatus()
        BathLocation(
            content = {
                Text(
                    text = "Политехнический институт",
                    style = MaterialTheme.typography.body1
                )
            }
        )
        Options()
        Description()
        DetailsButtons(onBathClick)
    }
}

@Composable
fun Options() {
    FlowRow(
        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
        mainAxisSpacing = 5.dp,
        crossAxisSpacing = 5.dp
    ) {
        OptionItem("Бассейн")
        OptionItem("Чан")
        OptionItem("Фитскомната")
        OptionItem("Мангал")
        OptionItem("Массаж")
        OptionItem("Парение для детей")
    }
}

@Composable
fun OptionItem(text: String) {
    Text(
        modifier = Modifier
            .background(
                color = Color(0xFF446ab6),
                shape = RoundedCornerShape(50.dp)
            )
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
        text = text,
        color = MaterialTheme.colors.surface,
        style = MaterialTheme.typography.body2
    )
}

@Composable
fun Description() {
    Text(
        text = "Русская  баня, финская баня, японская баня, офуро, чан на дровах",
        style = MaterialTheme.typography.body1
    )
}
