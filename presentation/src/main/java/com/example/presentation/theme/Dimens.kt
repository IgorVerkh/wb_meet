package com.example.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
internal data class Dimens(
    val paddingDefault: Dp
)

internal val dimensions = Dimens(
    paddingDefault = 8.dp
)