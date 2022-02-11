package ru.dimagor555.parilka.android.featureBath.presentation.bath

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.viewModel
import ru.dimagor555.parilka.android.featureBath.presentation.bath.components.BathScreenContent
import ru.dimagor555.parilka.android.featureBath.presentation.bath.components.BathTopAppBar
import ru.dimagor555.parilka.android.featureBath.presentation.bath.model.BathStore

@Composable
fun BathScreen(
    bathId: Int,
    onBackClick: () -> Unit
) {
    val viewModel by viewModel<BathViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(bathId) {
        viewModel.sendAction(BathStore.Action.LoadBath(bathId))
    }

    Scaffold(
        modifier = Modifier,
        topBar = { BathTopAppBar(onBackClick) },
        content = { BathScreenContent(state.bathState) }
    )
}