package com.example.ui_v2.screen.appointment.appointment_code

import androidx.compose.foundation.text.input.TextFieldState
import com.example.ui_v2.component.LoadingButtonState

internal data class AppointmentCodeState(
    val textFieldState: TextFieldState = TextFieldState(),
    val description: String = "",
    val hint: String = "",
    val isWrongCode: Boolean = false,
    val timer: Int = 0,
    val primaryActionButtonState: LoadingButtonState = LoadingButtonState.ACTIVE,
)
