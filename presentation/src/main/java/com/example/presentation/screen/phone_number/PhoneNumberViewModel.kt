package com.example.presentation.screen.phone_number

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class PhoneNumberViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PhoneNumberState())
    private val uiState: StateFlow<PhoneNumberState> = _uiState

    fun getUiState() = uiState

    fun updatePhoneNumber(phoneNumber: String) {
        _uiState.value =
            _uiState.value.copy(phoneNumber = phoneNumber, continueButtonEnabled = true)
    }

    fun updateCountryCode(countryPhoneData: CountryPhoneData) {
        _uiState.value = _uiState.value.copy(countryPhoneData = countryPhoneData)
    }

    private fun validatePhoneNumber() {
        TODO("Not implemented")
    }
}
