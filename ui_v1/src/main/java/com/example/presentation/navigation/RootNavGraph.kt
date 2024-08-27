package com.example.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.presentation.screen.splash_screen.SplashScreen
import com.example.presentation.screen.all_meetings.AllMeetings
import com.example.presentation.screen.communities.Communities
import com.example.presentation.screen.community_details.CommunityDetails
import com.example.presentation.screen.meeting_details.MeetingDetails
import com.example.presentation.screen.miscellaneous.Miscellaneous
import com.example.presentation.screen.my_meetings.MyMeetings
import com.example.presentation.screen.otp_confirmation.OTPConfirmation
import com.example.presentation.screen.phone_number.PhoneNumber
import com.example.presentation.screen.profile.Profile
import com.example.presentation.screen.profile_creation.ProfileCreation
import com.example.presentation.screen.ui_kit.UiKit

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
        meetingsDetails(navController = navController)
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
        communityDetails(navController = navController)
        meetingsDetails(navController = navController)
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
        meetingsDetails(navController = navController)
    }
}

private fun NavGraphBuilder.meetingsDetails(navController: NavHostController) {
    composable(
        route = "${Screen.MeetingDetails.route}/{id}",
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getInt("id")
            ?: throw IllegalArgumentException("Missing 'id' argument")
        MeetingDetails(
            id = id,
            navController = navController
        )
    }
}

private fun NavGraphBuilder.communityDetails(navController: NavHostController) {
    composable(
        route = "${Screen.CommunityDetails.route}/{id}",
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getInt("id")
            ?: throw IllegalArgumentException("Missing 'id' argument")
        CommunityDetails(
            id = id,
            navController = navController
        )
    }
}