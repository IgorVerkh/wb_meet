package com.example.presentation.screen.otp_confirmation

internal sealed class OTPConfirmationState {
    data class Input(
        val code: String = "",
        val isCodeValid: Boolean = false,
    ) : OTPConfirmationState()

    data object Error : OTPConfirmationState()
}