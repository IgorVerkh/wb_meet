package com.example.ui_v2.screen.interests

import com.example.ui_v2.component.LoadingButtonState

internal data class InterestsState(
    val interestsMap: Map<String, Boolean> = mapOf(),
    val saveButtonState: LoadingButtonState = LoadingButtonState.ACTIVE,
)
