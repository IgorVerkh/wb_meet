package com.example.ui_v2.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// TODO: rename colors
internal data class Colors(
    val primary: Color,
    val brandColorDefault: Color,
    val brandColorDark: Color,
    val brandColorDarkMode: Color,
    val brandColorLight: Color,
    val brandColorBackground: Color,
    val neutralColorActive: Color,
    val neutralColorLine: Color,
    val neutralColorWeak: Color,
    val neutralColorDisabled: Color,
    val avatarBorder: Color,
    val sixSixSix: Color,
    val disabled: Color,
    val disabledContent: Color,
    val metadata: Color,
    val error: Color,
)

enum class ColorStyle {
    Base
}

internal object MeetTheme {
    val colors: Colors
        @Composable
        get() = LocalColors.current
    val typo: Typography
        @Composable
        get() = LocalTypo.current
    val dimens: Dimens
        @Composable
        get() = LocalDimens.current
}

internal val LocalColors = staticCompositionLocalOf { lightPalette }
internal val LocalTypo = staticCompositionLocalOf { typography }
internal val LocalDimens = staticCompositionLocalOf { dimensions }