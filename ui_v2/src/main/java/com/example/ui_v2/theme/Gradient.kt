package com.example.ui_v2.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

internal val gradientViolet = Brush.horizontalGradient(
    listOf(
        Color(0xFFED3CCA), Color(0xFFDF34D2), Color(0xFFD02BD9),
        Color(0xFFBF22E1), Color(0xFFAE1AE8), Color(0xFF9A10F0),
        Color(0xFF8306F7), Color(0xFF6600FF)
    )
)

internal val gradientSmoky = Brush.horizontalGradient(
    listOf(
        Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC),
        Color(0xFFFBF0FD), Color(0xFFF9EFFD), Color(0xFFF8EEFE),
        Color(0xFFF6EEFE), Color(0xFFF4EDFF)
    )
)