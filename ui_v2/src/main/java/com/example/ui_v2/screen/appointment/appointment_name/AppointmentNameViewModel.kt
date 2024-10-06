package com.example.ui_v2.screen.appointment.appointment_name

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class AppointmentNameViewModel(

) : ViewModel() {
    private val _uiState = MutableStateFlow(AppointmentNameState())
    private val uiState: StateFlow<AppointmentNameState> = _uiState

    fun getUiState() = uiState
}