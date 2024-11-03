package com.example.ui_v2.screen.main

import com.example.ui_v2.model.InterestTag


internal data class MainScreenState(
    val searchState: SearchState = SearchState.Empty,
    val suggestedMeetings: List<Int> = emptyList(),
    val soonMeetings: List<Int> = emptyList(),
    val suggestedCommunities: List<Int> = emptyList(),
    val filterTags: List<InterestTag> = emptyList(),
    val content: List<Int> = emptyList(),
)

internal sealed interface SearchState {
    data object Empty : SearchState
    data class Search(val searchQuery: String) : SearchState
}