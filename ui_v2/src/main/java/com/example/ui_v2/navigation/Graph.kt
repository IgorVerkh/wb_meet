package com.example.ui_v2.navigation

internal sealed class Graph(val route: String) {
    data object Onboarding : Graph("onboarding")
    data object Main : Graph("main")
}