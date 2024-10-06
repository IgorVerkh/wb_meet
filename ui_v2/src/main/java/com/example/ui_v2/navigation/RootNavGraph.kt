package com.example.ui_v2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.ui_v2.screen.interests.InterestsScreen
import com.example.ui_v2.screen.people.PeopleScreen
import com.example.ui_v2.screen.splash.SplashScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.People.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        onboardingGraph(navController)
        // TODO: remove
        composable(Screen.People.route) {
            PeopleScreen(navController = navController)
        }
    }
}

private fun NavGraphBuilder.onboardingGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.OnboardingInterests.route,
        route = Graph.Onboarding.route
    ) {
        composable(Screen.OnboardingInterests.route) {
            InterestsScreen(navController = navController)
        }
    }
}