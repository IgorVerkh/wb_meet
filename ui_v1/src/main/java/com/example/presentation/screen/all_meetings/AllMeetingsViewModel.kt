package com.example.presentation.screen.all_meetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetAllMeetingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class AllMeetingsViewModel(
    private val getAllMeetingsUseCase: GetAllMeetingsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AllMeetingsState())
    private val uiState: StateFlow<AllMeetingsState> = _uiState

    fun getUiState() = uiState

    init {
        getAllMeetings()
    }

    private fun getAllMeetings() {
        viewModelScope.launch {
            getAllMeetingsUseCase().collectLatest { meetings ->
                _uiState.value =
                    AllMeetingsState(
                        meetingsList = meetings,
                    )
            }
        }
    }
}
