package ru.dimagor555.parilka.android.featureBath.presentation.bath.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import ru.dimagor555.parilka.android.featureBath.presentation.components.BathLocation
import ru.dimagor555.parilka.android.featureBath.presentation.components.CostQuantityStatus
import ru.dimagor555.parilka.android.featureBath.presentation.components.DetailsButtons
import ru.dimagor555.parilka.bath.domain.bathoffer.Bath

@Composable
fun BathFullDescription(
    minPrice: UInt,
    capacity: UByte,
    phoneNumber: String,
    distinct: String?,
    address: String,
    subwayStation: String?,
    bathTypes: Set<String>,
    servicesByTypes: Map<Bath.ServiceType, Set<String>>,
    minRentHours: UByte,
    priceNames: Set<String>,
    description: String?,
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .background(Color(0xFFe6ecf5)),
    ) {
        CostQuantityStatus(minPrice, capacity)
        DetailsButtons({}, phoneNumber)
        BathLocation(
            content = {
                Column() {
                    subwayStation?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.body1
                        )
                    }
                    Text(
                        text = "$distinct $address",
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        )
        AnnotatedText("Виды парной: ", bathTypes.toString().drop(1).dropLast(1))
        servicesByTypes.forEach {
            when (it.key) {
                Bath.ServiceType.BATH -> AnnotatedText("Банные услуги: ",
                    it.value.toString().drop(1).dropLast(1))
                Bath.ServiceType.AQUA -> AnnotatedText("Аквазона: ",
                    it.value.toString().drop(1).dropLast(1))
                Bath.ServiceType.ADDITIONAL -> AnnotatedText("Доп. Услуги: ",
                    it.value.toString().drop(1).dropLast(1))
                Bath.ServiceType.FOOD -> AnnotatedText("Кухня: ",
                    it.value.toString().drop(1).dropLast(1))
            }
        }
        BathPrice(priceNames, minRentHours.toInt())
        BathDescription(description)
        LocationOnMap(distinct, address)
        ReviewsOnGoogleMaps()
        BookBath(phoneNumber)
    }
}

@Composable
fun AnnotatedText(annotation: String, text: String) {
    Text(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
        text = buildAnnotatedString {
            append(AnnotatedString(annotation, spanStyle = SpanStyle(Color(0xFF004dff))))
            append(text)
        },
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun BathPrice(priceNames: Set<String>, minHours: Int) {
    Column(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
    ) {
        Text(
            text = "Цены:",
            color = Color(0xFF002ea3),
            style = MaterialTheme.typography.subtitle1
        )
        priceNames.forEach {
            Text(
                text = it,
                style = MaterialTheme.typography.subtitle2
            )
        }
        Text(
            text = "Минимальное количество часов аренды: $minHours",
            color = MaterialTheme.colors.error.copy(0.5f),
            style = MaterialTheme.typography.caption
        )
    }
}

@Composable
fun BathDescription(description: String?) {
    Column(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
    ) {
        Text(
            text = "Описание:",
            color = Color(0xFF002ea3),
            style = MaterialTheme.typography.subtitle1
        )
        description?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun LocationOnMap(distinct: String?, address: String) {
    Column(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
    ) {
        Text(
            text = "Расположение:",
            color = Color(0xFF002ea3),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "$distinct $address",
            style = MaterialTheme.typography.caption
        )
    }
}

@Composable
fun ReviewsOnGoogleMaps() {
    Column(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
    ) {
        Text(
            text = "Отзывы на гугл картах:",
            color = Color(0xFF002ea3),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
fun BookBath(phoneNumber: String) {
    Column(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
    ) {
        Text(
            text = "Бронировать",
            color = Color(0xFF002ea3),
            style = MaterialTheme.typography.subtitle1
        )
        DetailsButtons({}, phoneNumber)
    }
}
