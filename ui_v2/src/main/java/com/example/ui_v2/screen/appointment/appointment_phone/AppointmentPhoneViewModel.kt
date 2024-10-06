package com.example.ui_v2.screen.appointment.appointment_phone

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class AppointmentPhoneViewModel(

) : ViewModel() {
    private val _uiState = MutableStateFlow(AppointmentPhoneState())
    private val uiState: StateFlow<AppointmentPhoneState> = _uiState

    fun getUiState() = uiState
}