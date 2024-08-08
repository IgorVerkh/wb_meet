package com.example.presentation.screen.profile_creation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class ProfileCreationViewModel(

) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileCreationState())
    private val uiState: StateFlow<ProfileCreationState> = _uiState

    fun getUiState() = uiState

    fun updateName(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    fun updateSecondName(secondName: String) {
        _uiState.value = _uiState.value.copy(secondName = secondName)
    }

    fun updateAvatar() {
        TODO("Not yet implemented")
    }

}