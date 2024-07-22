package com.example.presentation.screen.community_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCommunityById
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class CommunityDetailsViewModel(
    private val getCommunityById: GetCommunityById
) : ViewModel() {
    private val _uiState = MutableStateFlow<CommunityDetailsState>(CommunityDetailsState.Loading)
    private val uiState: StateFlow<CommunityDetailsState> = _uiState

    fun getUiState() = uiState

    // TODO: fix so it wouldn't trigger on recompositions or add id to vm constructor
    fun getCommunityDetails(id: Int) {
        viewModelScope.launch {
            getCommunityById(id = id)
                .onStart { _uiState.value = CommunityDetailsState.Loading }
                .catch { _uiState.value = CommunityDetailsState.Error }
                .collectLatest { community ->
                    _uiState.value = CommunityDetailsState.Success(community = community)
                }
        }
    }
}