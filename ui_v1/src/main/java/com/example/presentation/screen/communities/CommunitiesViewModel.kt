package com.example.presentation.screen.communities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetAllCommunitiesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class CommunitiesViewModel(
    private val getAllCommunitiesUseCase: GetAllCommunitiesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(CommunitiesState())
    private val uiState: StateFlow<CommunitiesState> = _uiState

    fun getUiState() = uiState

    init {
        getAllCommunities()
    }

    private fun getAllCommunities() {
        viewModelScope.launch {
            getAllCommunitiesUseCase().collectLatest { communities ->
                _uiState.value = CommunitiesState(
                    communitiesList = communities
                )
            }
        }
    }
}