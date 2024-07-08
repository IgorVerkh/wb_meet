package ru.wb.meetings.ui.navigation

import androidx.compose.runtime.Composable


import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.wb.meetings.ui.screen.all_meetings.AllMeetings
import ru.wb.meetings.ui.screen.my_meetings.MyMeetings
import ru.wb.meetings.ui.screen.profile.Profile
import ru.wb.meetings.ui.screen.ui_kit.UiKit

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.AllMeetings.route
    ) {
        composable(Screen.AllMeetings.route) {
            AllMeetings(navController = navController)
        }
        composable(Screen.Profile.route) {
            Profile(navController = navController)
        }
        composable(Screen.MyMeetings.route) {
            MyMeetings(navController = navController)
        }
        composable(Screen.UiKit.route) {
            UiKit(navController = navController)
        }
    }
}