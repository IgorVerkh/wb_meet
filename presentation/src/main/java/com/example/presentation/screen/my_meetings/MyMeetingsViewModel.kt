package com.example.presentation.screen.my_meetings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class MyMeetingsViewModel(

) : ViewModel() {
    private val _uiState = MutableStateFlow(MyMeetingsState())
    private val uiState: StateFlow<MyMeetingsState> = _uiState

    fun getUiState() = uiState
}