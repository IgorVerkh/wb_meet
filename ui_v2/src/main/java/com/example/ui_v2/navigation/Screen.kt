package com.example.ui_v2.navigation

internal sealed class Screen(val route: String) {
    data object Splash : Screen("splash_screen")
    data object OnboardingGeo : Screen("onboarding_geo")
    data object OnboardingInterests : Screen("onboarding_interests")
    data object Main : Screen("main")
    data object Event : Screen("event")
    data object People : Screen("people")
    data object Community : Screen("community")
    data object AppointmentName : Screen("appointment_name")
    data object AppointmentPhoneNumber : Screen("appointment_phone_number")
    data object AppointmentOTP : Screen("appointment_otp")
    data object AppointmentSuccess : Screen("appointment_success")
    data object Profile : Screen("profile")
    data object ProfileEdit : Screen("profile_edit")
    data object ProfileEditInterests : Screen("profile_edit_interests")
    data object ProfileEditPicture : Screen("profile_edit_picture")
    data object ProfileDelete : Screen("profile_delete")
    // TODO: make UI kit screen
}