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
    allFilters: Map<String, Set<String>>,
    markedFilters: Set<String>,
    onClick: (String, Boolean) -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(bottom = 70.dp)
            .fillMaxSize(),
    ) {
        allFilters.forEach { (title, filters) ->
            FilterCard(title, filters, markedFilters, Icons.Default.Home, onClick)
        }
    }
}
