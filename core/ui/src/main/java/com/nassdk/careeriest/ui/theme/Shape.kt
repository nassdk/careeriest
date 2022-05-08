package com.nassdk.careeriest.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class StShapes(
    val primaryButtonShape: Shape,
    val primaryViewShape: Shape,
)

val shapes = StShapes(
    primaryButtonShape = RoundedCornerShape(size = 12.dp),
    primaryViewShape = RoundedCornerShape(size = 12.dp)
)