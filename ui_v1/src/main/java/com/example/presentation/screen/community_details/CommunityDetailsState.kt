package com.example.presentation.screen.community_details

import com.example.domain.model.Community

// TODO: add error type
internal sealed class CommunityDetailsState {
    data object Loading : CommunityDetailsState()
    data class Success(val community: Community) : CommunityDetailsState()
    data object Error : CommunityDetailsState()
}
