package ru.dimagor555.parilka.android.featureBath.presentation.overview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import ru.dimagor555.parilka.android.featureBath.presentation.components.BathLocation
import ru.dimagor555.parilka.android.featureBath.presentation.components.CostQuantityStatus
import ru.dimagor555.parilka.android.featureBath.presentation.components.DetailsButtons
import ru.dimagor555.parilka.bath.domain.bathoffer.Bath

@Composable
fun BathDescription(
    onBathClick: () -> Unit,
    price: UInt,
    capacity: UByte,
    subwayStation: String?,
    servicesByTypes: Map<Bath.ServiceType, Set<String>>,
    bathTypes: Set<String>,
    phoneNumber: String
) {
    Column(
        modifier = Modifier.padding(8.dp),
    ) {
        CostQuantityStatus(price, capacity)
        if (!subwayStation.isNullOrEmpty()) {
            BathLocation(
                content = {
                    Text(
                        text = subwayStation,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
        }
        Options(servicesByTypes)
        Description(bathTypes)
        DetailsButtons(onBathClick, phoneNumber)
    }
}

@Composable
fun Options(servicesByTypes: Map<Bath.ServiceType, Set<String>>) {
    FlowRow(
        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
        mainAxisSpacing = 5.dp,
        crossAxisSpacing = 5.dp
    ) {
        servicesByTypes.forEach {
            it.value.forEach { service ->
                OptionItem(service)
            }
        }
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
fun Description(bathTypes: Set<String>) {
    Text(
        text = bathTypes.toString().drop(1).dropLast(1),
        style = MaterialTheme.typography.body1
    )
}
