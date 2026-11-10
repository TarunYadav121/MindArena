package com.example.mindarena.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val MindArenaColorScheme = lightColorScheme(
    primary = Terracotta,
    onPrimary = PaperWhite,
    primaryContainer = SelectedBackground,
    onPrimaryContainer = Terracotta,
    secondary = MutedTaupe,
    onSecondary = PaperWhite,
    background = WarmCream,
    onBackground = Espresso,
    surface = PaperWhite,
    onSurface = Espresso,
    surfaceVariant = TagBackground,
    onSurfaceVariant = Espresso,
    outline = SandBorder,
    error = MutedBrickError,
    onError = PaperWhite
)

@Composable
fun MindArenaTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MindArenaColorScheme,
        typography = Typography,
        content = content
    )
}
