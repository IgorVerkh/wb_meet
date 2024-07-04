package ru.wb.meetings.ui.navigation

sealed class Screen(val route: String) {
    data object UiKit : Screen("ui_kit")
    data object AllMeetings : Screen("all_meetings")
    data object MyMeetings : Screen("my_meetings")
    data object Profile : Screen("profile")
}