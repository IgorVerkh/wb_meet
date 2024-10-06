package com.example.ui_v2.screen.main

internal sealed interface MainScreenState {
    data object Loading : MainScreenState
    data class Success(val data: String) : MainScreenState
    data class Error(val message: String) : MainScreenState
}