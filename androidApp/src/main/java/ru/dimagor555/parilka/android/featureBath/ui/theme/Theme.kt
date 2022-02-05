package ru.dimagor555.parilka.android.featureBath.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Blue400,
    primaryVariant = Blue500,
    secondary = Blue600,
    secondaryVariant = Green300
)

@Composable
fun ParilkaTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = MontserratTypography,
        shapes = Shapes,
        content = content
    )
}