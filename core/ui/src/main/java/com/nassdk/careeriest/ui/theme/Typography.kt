package com.nassdk.careeriest.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nassdk.careeriest.ui.R

val familyPoppins = FontFamily(
    Font(resId = R.font.poppins_bold, weight = FontWeight.Bold),
    Font(resId = R.font.poppins_medium, weight = FontWeight.Medium),
    Font(resId = R.font.poppins_regular, weight = FontWeight.Normal, style = FontStyle.Normal)
)

data class StTypography(
    val headerMed30: TextStyle,
    val headerMed24: TextStyle,
    val bodyMed16: TextStyle,
    val bodyBold14: TextStyle,
    val bodyMed12: TextStyle,
    val bodyReg12: TextStyle,
    val buttonMed15: TextStyle,
    val buttonBold15: TextStyle
)

val typography = StTypography(
    headerMed30 = TextStyle(
        fontSize = 30.sp,
        fontFamily = familyPoppins,
        fontWeight = FontWeight.Medium
    ),
    headerMed24 = TextStyle(
        fontSize = 24.sp,
        fontFamily = familyPoppins,
        fontWeight = FontWeight.Medium
    ),
    bodyMed16 = TextStyle(
        fontSize = 16.sp,
        fontFamily = familyPoppins,
        fontWeight = FontWeight.Medium
    ),
    bodyBold14 = TextStyle(
        fontSize = 14.sp,
        fontFamily = familyPoppins,
        fontWeight = FontWeight.Bold
    ),
    bodyMed12 = TextStyle(
        fontSize = 12.sp,
        fontFamily = familyPoppins,
        fontWeight = FontWeight.Medium
    ),
    bodyReg12 = TextStyle(
        fontSize = 12.sp,
        fontFamily = familyPoppins
    ),
    buttonMed15 = TextStyle(
        fontSize = 15.sp,
        fontFamily = familyPoppins,
        fontWeight = FontWeight.Medium
    ),
    buttonBold15 = TextStyle(
        fontSize = 15.sp,
        fontFamily = familyPoppins,
        fontWeight = FontWeight.Bold
    )
)

