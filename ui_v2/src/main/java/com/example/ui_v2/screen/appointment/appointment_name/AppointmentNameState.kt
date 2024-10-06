package com.example.ui_v2.screen.appointment.appointment_name

import androidx.compose.foundation.text.input.TextFieldState
import com.example.ui_v2.component.LoadingButtonState

internal data class AppointmentNameState(
    val textFieldState: TextFieldState = TextFieldState(),
    val description: String = "",
    val primaryActionButtonState: LoadingButtonState = LoadingButtonState.DISABLED,
)
