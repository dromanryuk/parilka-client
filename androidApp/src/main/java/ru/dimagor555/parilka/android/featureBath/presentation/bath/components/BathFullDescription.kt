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
import androidx.compose.ui.unit.sp
import ru.dimagor555.parilka.android.featureBath.presentation.components.BathLocation
import ru.dimagor555.parilka.android.featureBath.presentation.components.CostQuantityStatus
import ru.dimagor555.parilka.android.featureBath.presentation.components.DetailsButtons

@Composable
fun BathFullDescription() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .background(Color(0xFFe6ecf5)),
    ) {
        CostQuantityStatus()
        DetailsButtons({})
        BathLocation(
            content = {
                Column() {
                    Text(
                        text = "Политехнический институт",
                        color = MaterialTheme.colors.onSurface,
                        fontSize = 18.sp,
                    )
                    Text(
                        text = "обл: Киевская, пос. Козин. ул. Лбуховское шоссе, 55",
                        color = MaterialTheme.colors.onSurface,
                        fontSize = 10.sp,
                    )
                }
            }
        )
        AnnotatedText("Виды парной: ", "Руская баня, Хаммам, Финская баня, Нифракрасная баня")
        AnnotatedText("Банные услуги: ", "Проф. парение, детское парение, фиточан")
        AnnotatedText("Аквазона: ", "Бассейн, Купель")
        AnnotatedText("Доп. Услуги: ", "Телевизор, кальян, массаж, кондиционер, караоке, Wi-Fi, бильярд, банкетный зал")
        AnnotatedText("Кухня: ", "Мангал, Бар-ресторан, разливное пиво, свежие морепродукты")
        BathPrice(200, 1000, 2)
        BathDescription()
        LocationOnMap()
        ReviewsOnGoogleMaps()
        BookBath()
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
        fontSize = 16.sp,
    )
}

@Composable
fun BathPrice(hourPrice: Int, dayPrice: Int, minHours: Int) {
    Column(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
    ) {
        Text(
            text = "Цены:",
            color = Color(0xFF002ea3),
            fontSize = 20.sp,
        )
        Text(
            text = "Час аренды - $hourPrice грн",
            color = MaterialTheme.colors.onSurface,
            fontSize = 18.sp,
        )
        Text(
            text = "Аренда на день - $dayPrice грн",
            color = MaterialTheme.colors.onSurface,
            fontSize = 18.sp,
        )
        Text(
            text = "Минимальное количество часов аренды: $minHours",
            color = MaterialTheme.colors.error.copy(0.5f),
            fontSize = 10.sp,
        )
    }
}

@Composable
fun BathDescription() {
    Column(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
    ) {
        Text(
            text = "Описание:",
            color = Color(0xFF002ea3),
            fontSize = 20.sp,
        )
        Text(
            text = "Люди с плохой переносимостью высоких температур не всегда могут порадовать себя посещением классической «русской бани»." +
                    "Отличной альтернативой послужат Римская баня и Турецкий паровой хаммам за счет своего «щадящего» режима в процессе парения.",
            color = MaterialTheme.colors.onSurface,
            fontSize = 20.sp,
        )
    }
}

@Composable
fun LocationOnMap() {
    Column(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
    ) {
        Text(
            text = "Расположение:",
            color = Color(0xFF002ea3),
            fontSize = 20.sp,
        )
        Text(
            text = "обл: Киевская, пос. Козин. ул. Лбуховское шоссе, 55",
            color = MaterialTheme.colors.onSurface,
            fontSize = 10.sp,
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
            fontSize = 20.sp,
        )
    }
}

@Composable
fun BookBath() {
    Column(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
    ) {
        Text(
            text = "Бронировать",
            color = Color(0xFF002ea3),
            fontSize = 20.sp,
        )
        DetailsButtons({})
    }
}