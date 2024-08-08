package com.example.presentation.screen.phone_number

/**
 * Input -> user is typing their phone number
 * Error -> there was an error when trying to send the number (e.x. network)
 *
 * Error can occur only after submitting the number
 * TODO: Implement error logic
 **/
data class PhoneNumberState(
    val countryPhoneData: CountryPhoneData = CountryPhoneData.RUSSIA,
    val phoneNumber: String = "",
    val continueButtonEnabled: Boolean = false,
)
