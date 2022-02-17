package ru.dimagor555.parilka.android.featureBath.presentation.filter

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.viewModel
import ru.dimagor555.parilka.android.featureBath.presentation.filter.components.FilterBottomAppBar
import ru.dimagor555.parilka.android.featureBath.presentation.filter.components.FilterScreenContent
import ru.dimagor555.parilka.android.featureBath.presentation.filter.components.FilterTopAppBar

@Composable
fun FilterScreen(
    onBackClick: () -> Unit
) {
    val viewModel by viewModel<FilterViewModel>()
    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier = Modifier,
        topBar = { FilterTopAppBar(onBackClick) },
        bottomBar = { FilterBottomAppBar(onBackClick) },
        content = { FilterScreenContent(
            state = state.filtersState,
            onClick = {}
        ) },
        backgroundColor = MaterialTheme.colors.secondary
    )
}