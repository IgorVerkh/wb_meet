package com.example.ui_v2.screen.appointment.appointment_code

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class AppointmentCodeViewModel(

) : ViewModel() {
    private val _uiState = MutableStateFlow(AppointmentCodeState())
    private val uiState: StateFlow<AppointmentCodeState> = _uiState

    fun getUiState() = uiState
}