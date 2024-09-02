package com.example.ui_v2.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun MeetTheme(
    colorStyle: ColorStyle = ColorStyle.Base,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when (colorStyle) {
        ColorStyle.Base -> lightPalette
    }

    CompositionLocalProvider(
        LocalColors provides colorScheme,
        LocalTypo provides typography,
        LocalDimens provides dimensions,
        content = content
    )
}