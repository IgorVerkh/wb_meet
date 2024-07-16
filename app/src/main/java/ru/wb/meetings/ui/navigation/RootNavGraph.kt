package ru.wb.meetings.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ru.wb.meetings.ui.screen.SplashScreen
import ru.wb.meetings.ui.screen.all_meetings.AllMeetings
import ru.wb.meetings.ui.screen.communities.Communities
import ru.wb.meetings.ui.screen.community_details.CommunityDetails
import ru.wb.meetings.ui.screen.meeting_details.MeetingDetails
import ru.wb.meetings.ui.screen.miscellaneous.Miscellaneous
import ru.wb.meetings.ui.screen.my_meetings.MyMeetings
import ru.wb.meetings.ui.screen.otp_confirmation.OTPConfirmation
import ru.wb.meetings.ui.screen.phone_number.PhoneNumber
import ru.wb.meetings.ui.screen.profile.Profile
import ru.wb.meetings.ui.screen.profile_creation.ProfileCreation
import ru.wb.meetings.ui.screen.ui_kit.UiKit

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        authGraph(navController)
        meetingsGraph(navController)
        communitiesGraph(navController)
        miscGraph(navController)
        composable(Screen.UiKit.route) {
            UiKit(navController = navController)
        }
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.PhoneNumber.route,
        route = Graph.AuthGraph.route
    ) {
        composable(Screen.PhoneNumber.route) {
            PhoneNumber(navController = navController)
        }
        composable(Screen.OTPConfirmation.route) {
            OTPConfirmation(navController = navController)
        }
        composable(Screen.ProfileCreation.route) {
            ProfileCreation(navController = navController)
        }
    }
}

private fun NavGraphBuilder.meetingsGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.AllMeetings.route,
        route = Graph.MeetingsGraph.route
    ) {
        composable(Screen.AllMeetings.route) {
            AllMeetings(navController = navController)
        }
        composable(Screen.MeetingDetails.route) {
            MeetingDetails(navController = navController)
        }
    }
}

private fun NavGraphBuilder.communitiesGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Communities.route,
        route = Graph.CommunitiesGraph.route
    ) {
        composable(Screen.Communities.route) {
            Communities(navController = navController)
        }
        composable(Screen.CommunityDetails.route) {
            CommunityDetails(navController = navController)
        }
        composable(Screen.MeetingDetails.route) {
            MeetingDetails(navController = navController)
        }
    }
}

private fun NavGraphBuilder.miscGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Miscellaneous.route,
        route = Graph.MiscGraph.route
    ) {
        composable(Screen.Miscellaneous.route) {
            Miscellaneous(navController = navController)
        }
        composable(Screen.Profile.route) {
            Profile(navController = navController)
        }
        composable(Screen.MyMeetings.route) {
            MyMeetings(navController = navController)
        }
        composable(Screen.MeetingDetails.route) {
            MeetingDetails(navController = navController)
        }
    }
}