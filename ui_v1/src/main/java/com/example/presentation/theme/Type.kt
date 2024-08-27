package com.example.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.presentation.R

val SfProDisplay = FontFamily(
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_bold, FontWeight.Bold)
)

val InterDisplay = FontFamily(
    Font(R.font.inter_display_regular, FontWeight.Normal),
    Font(R.font.inter_display_semibold, FontWeight.SemiBold),
    Font(R.font.inter_display_bold, FontWeight.Bold),
)

val Heading1 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
    lineHeight = 38.sp,
    letterSpacing = 0.5.sp,
)

val Heading2 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.5.sp
)

val Subheading1 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 18.sp,
    lineHeight = 30.sp,
    letterSpacing = 0.5.sp
)

val Subheading2 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.5.sp
)

val Body1 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

val Body2 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

val Metadata1 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.5.sp
)

val Metadata2 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
)

val Metadata3 = TextStyle(
    fontFamily = InterDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 10.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
)

val typography = Typography(
    displayLarge = Heading1,
    displayMedium = Heading2,
    titleLarge = Subheading1,
    titleMedium = Subheading2,
    bodyLarge = Body1,
    bodyMedium = Body2,
    labelLarge = Metadata1,
    labelMedium = Metadata2,
    labelSmall = Metadata3
)