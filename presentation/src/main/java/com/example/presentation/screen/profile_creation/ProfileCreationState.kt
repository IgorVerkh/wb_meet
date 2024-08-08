package com.example.presentation.screen.profile_creation

internal data class ProfileCreationState(
    val avatar: Any? = null,
    val name: String = "",
    val secondName: String = "",
    val isSaveButtonEnabled: Boolean = true
)