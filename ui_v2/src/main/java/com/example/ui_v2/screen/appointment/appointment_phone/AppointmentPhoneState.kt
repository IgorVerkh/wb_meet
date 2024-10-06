package com.example.ui_v2.screen.appointment.appointment_phone

import androidx.compose.foundation.text.input.TextFieldState
import com.example.ui_v2.common.CountryPhoneData
import com.example.ui_v2.component.LoadingButtonState

internal data class AppointmentPhoneState(
    val textFieldState: TextFieldState = TextFieldState(),
    val description: String = "",
    val selectedCountry: CountryPhoneData = CountryPhoneData.RUSSIA,
    val primaryActionButtonState: LoadingButtonState = LoadingButtonState.DISABLED,
)