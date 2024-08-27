package com.example.presentation.screen.splash_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.IsAuthenticatedUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class SplashScreenViewModel(
    private val isAuthenticatedUseCase: IsAuthenticatedUseCase
) : ViewModel() {

    private var authStatus = false

    init {
        getAuthStatus()
    }

    fun isAuthenticated(): Boolean {
        return authStatus
    }

    private fun getAuthStatus() {
        viewModelScope.launch {
            isAuthenticatedUseCase().collectLatest {
                authStatus = it
            }
        }
    }
}