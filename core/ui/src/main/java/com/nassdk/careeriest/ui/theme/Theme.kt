package com.nassdk.careeriest.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object StTheme {
    val colors: StColors
        @Composable
        get() = LocalAeroColors.current

    val typography: StTypography
        @Composable
        get() = LocalStTypography.current

    val dimens: StDimens
        @Composable
        get() = LocalStDimens.current
}

val LocalAeroColors = staticCompositionLocalOf<StColors> {
    error("No colors provided")
}

val LocalStTypography = staticCompositionLocalOf<StTypography> {
    error("No typography provided")
}

val LocalStDimens = staticCompositionLocalOf<StDimens> {
    error("No dimens provided")
}