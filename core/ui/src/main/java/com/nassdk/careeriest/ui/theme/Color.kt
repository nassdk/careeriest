package com.nassdk.careeriest.ui.theme

import androidx.compose.ui.graphics.Color

data class StColors(
    val primaryBackgroundColor: Color,
    val secondaryBackgroundColor: Color,
    val thirdlyBackgroundColor: Color,
    val primaryTextColor: Color,
    val secondaryTextColor: Color,
    val thirdlyTextColor: Color,
    val fourthlyTextColor: Color,
    val fifthlyTextColor: Color,
    val primaryButtonColor: Color,
    val secondaryButtonColor: Color,
    val primaryButtonTextColor: Color,
    val secondaryButtonTextColor: Color
)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Black_181A1F = Color(0xFF181A1F)
val Black_434856 = Color(0xFF434856)
val Black_6F7890 = Color(0xFF6F7890)
val White_F5F7FC = Color(0xFFF5F7FC)
val Blue = Color(0xFF1C58F2)

internal val DarkPalette = StColors(
    primaryBackgroundColor = White_F5F7FC,
    secondaryBackgroundColor = White,
    thirdlyBackgroundColor = Blue,
    primaryTextColor = Black_181A1F,
    secondaryTextColor = Black_434856,
    thirdlyTextColor = Black_6F7890,
    fourthlyTextColor = Blue,
    fifthlyTextColor = White,
    primaryButtonColor = Blue,
    secondaryButtonColor = White,
    primaryButtonTextColor = White,
    secondaryButtonTextColor = Blue
)

internal val LightPalette = StColors(
    primaryBackgroundColor = White_F5F7FC,
    secondaryBackgroundColor = White,
    thirdlyBackgroundColor = Blue,
    primaryTextColor = Black_181A1F,
    secondaryTextColor = Black_434856,
    thirdlyTextColor = Black_6F7890,
    fourthlyTextColor = Blue,
    fifthlyTextColor = White,
    primaryButtonColor = Blue,
    secondaryButtonColor = White,
    primaryButtonTextColor = White,
    secondaryButtonTextColor = Blue
)