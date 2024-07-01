package ru.wb.meetings.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.wb.meetings.R

val SfProDisplay = FontFamily(
    Font(R.font.sf_pro_display_regular),
    Font(R.font.sf_pro_display_bold)
)

val Heading1 = TextStyle(
    fontFamily = SfProDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
    lineHeight = 38.sp,
    letterSpacing = 0.5.sp
)

val Heading2 = TextStyle(
    fontFamily = SfProDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.5.sp
)

val Subheading1 = TextStyle(
    fontFamily = SfProDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp,
    lineHeight = 30.sp,
    letterSpacing = 0.5.sp
)

val Subheading2 = TextStyle(
    fontFamily = SfProDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.5.sp
)

val Body1 = TextStyle(
    fontFamily = SfProDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

val Body2 = TextStyle(
    fontFamily = SfProDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

val Metadata1 = TextStyle(
    fontFamily = SfProDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.5.sp
)

val Metadata2 = TextStyle(
    fontFamily = SfProDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
)

val Metadata3 = TextStyle(
    fontFamily = SfProDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 10.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
)

val Typography = Typography(
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