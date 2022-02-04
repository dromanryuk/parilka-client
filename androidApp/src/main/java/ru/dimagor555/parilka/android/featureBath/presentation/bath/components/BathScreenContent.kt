package ru.dimagor555.parilka.android.featureBath.presentation.bath.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BathScreenContent() {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state)
            .background(Color(0xFFe6ecf5)),
    ) {
        BathName("Плакучая Ива - Русская баня")
        BathImages()
        BathFullDescription()
    }
}

@Composable
private fun BathName(name: String) {
    Text(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp, top = 20.dp),
        text = name,
        color = MaterialTheme.colors.onSurface,
        fontSize = 22.sp,
    )
}
