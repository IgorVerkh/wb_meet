package com.example.presentation.screen.otp_confirmation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class OTPConfirmationViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<OTPConfirmationState>(OTPConfirmationState.Input())
    private val uiState: StateFlow<OTPConfirmationState> = _uiState

    fun getUiState() = uiState

    fun updateCode(code: String) {
        val isCodeValid = validateCode(code)
        _uiState.value = OTPConfirmationState.Input(code = code, isCodeValid = isCodeValid)
    }

    private fun validateCode(code: String): Boolean {
        return code.length == 4
    }
}