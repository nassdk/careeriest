package com.nassdk.careeriest.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.nassdk.careeriest.ui.theme.*
import com.nassdk.careeriest.ui.theme.DarkPalette
import com.nassdk.careeriest.ui.theme.LightPalette

@Composable
fun StTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkPalette
    } else {
        LightPalette
    }

    CompositionLocalProvider(
        LocalAeroColors provides colors,
        LocalStTypography provides typography,
        LocalStDimens provides StDimens(),
        content = content
    )
}