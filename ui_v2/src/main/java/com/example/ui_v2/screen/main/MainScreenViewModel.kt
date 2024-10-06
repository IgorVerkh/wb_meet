package com.example.ui_v2.screen.main

import androidx.lifecycle.ViewModel
import com.example.ui_v2.screen.interests.InterestsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class MainScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(InterestsState())
    private val uiState: StateFlow<InterestsState> = _uiState

    fun getUiState() = uiState
}