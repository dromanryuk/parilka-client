package ru.dimagor555.parilka.android.featureBath.presentation.filter.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterScreenContent(
    onClick: () -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(bottom = 70.dp)
            .fillMaxSize(),
    ) {
        FilterCard("Виды парной", "Руская баня, Хаммам, Финская баня, Нифракрасная баня", Icons.Default.Home, {})
        FilterCard("Банные услуги", "Проф. парение, детское парение, фиточан", Icons.Default.Home, {})
        FilterCard("Аквазона", "Бассейн, Купель", Icons.Default.Home, {})
        FilterCard("Доп. Услуги", "Телевизор, кальян, массаж, кондиционер, караоке, Wi-Fi, бильярд, банкетный зал", Icons.Default.Home, {})
        FilterCard("Кухня", "Мангал, Бар-ресторан, разливное пиво, свежие морепродукты", Icons.Default.Home, {})
    }
}
