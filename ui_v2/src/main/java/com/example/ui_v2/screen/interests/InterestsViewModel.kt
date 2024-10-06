package com.example.ui_v2.screen.interests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

internal class InterestsViewModel(

) : ViewModel() {
    private val _uiState = MutableStateFlow(InterestsState())
    private val uiState = _uiState
        .onStart { loadData() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            InterestsState()
        )

    fun getUiState() = uiState

    private fun loadData() {

    }
}