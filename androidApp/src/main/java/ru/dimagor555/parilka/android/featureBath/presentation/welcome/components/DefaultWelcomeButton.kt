package ru.dimagor555.parilka.android.featureBath.presentation.welcome.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultWelcomeButton(onClick: () -> Unit, text: String) {
    Button(
        modifier = Modifier.fillMaxWidth().height(60.dp),
        onClick = { onClick() }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h3
        )
    }
}