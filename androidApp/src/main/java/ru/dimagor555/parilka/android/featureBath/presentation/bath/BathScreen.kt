package ru.dimagor555.parilka.android.featureBath.presentation.bath

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.dimagor555.parilka.android.featureBath.presentation.bath.components.BathScreenContent
import ru.dimagor555.parilka.android.featureBath.presentation.bath.components.BathTopAppBar

@Composable
fun BathScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = { BathTopAppBar(onBackClick) },
        content = { BathScreenContent() }
    )
}