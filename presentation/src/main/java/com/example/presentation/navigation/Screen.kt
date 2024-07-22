package com.example.presentation.navigation

internal sealed class Screen(val route: String) {
    data object UiKit : Screen("ui_kit_screen")
    data object AllMeetings : Screen("all_meetings_screen")
    data object MyMeetings : Screen("my_meetings_screen")
    data object Profile : Screen("profile_screen")
    data object Communities : Screen("communities_screen")
    data object CommunityDetails : Screen("community_details_screen/{id}")
    data object MeetingDetails : Screen("meeting_details_screen/{id}")
    data object SplashScreen : Screen("splash_screen_screen")
    data object PhoneNumber : Screen("phone_number_screen")
    data object OTPConfirmation : Screen("otp_confirmation_screen")
    data object ProfileCreation : Screen("profile_creation_screen")
    data object Miscellaneous : Screen("miscellaneous_screen")
}