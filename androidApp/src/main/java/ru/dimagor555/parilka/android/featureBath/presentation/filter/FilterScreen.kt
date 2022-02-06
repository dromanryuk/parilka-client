package ru.dimagor555.parilka.android.featureBath.presentation.filter

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.dimagor555.parilka.android.featureBath.presentation.filter.components.FilterBottomAppBar
import ru.dimagor555.parilka.android.featureBath.presentation.filter.components.FilterScreenContent
import ru.dimagor555.parilka.android.featureBath.presentation.filter.components.FilterTopAppBar

@Composable
fun FilterScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = { FilterTopAppBar(onBackClick) },
        bottomBar = { FilterBottomAppBar(onBackClick) },
        content = { FilterScreenContent({}) },
        backgroundColor = MaterialTheme.colors.secondary
    )
}