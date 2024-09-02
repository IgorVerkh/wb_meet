package com.example.ui_v2.theme

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ui_v2.R

val InterDisplay = FontFamily(
    Font(R.font.inter_display_regular, FontWeight.Normal),
    Font(R.font.inter_display_medium, FontWeight.Medium),
    Font(R.font.inter_display_semibold, FontWeight.SemiBold),
    Font(R.font.inter_display_bold, FontWeight.Bold),
)

val Regular19 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 19.sp
)

val Medium14 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
)

val Medium16 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
)

val Medium18 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp,
)

val Medium22 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 22.sp,
)

val SemiBold14 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
)

val SemiBold18 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 18.sp,
)

val SemiBold24 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
)

val SemiBold49 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 49.sp,
)

val Bold34 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 34.sp
)

val typography = Typography(
    displayLarge = SemiBold49,
    displayMedium = Bold34,
    titleLarge = SemiBold24,
    titleMedium = Medium22,
    titleSmall = Medium18,
    bodyLarge = Medium16,
    bodyMedium = Regular19,
    bodySmall = Medium14,
    labelLarge = SemiBold18,
    labelMedium = SemiBold14,
)