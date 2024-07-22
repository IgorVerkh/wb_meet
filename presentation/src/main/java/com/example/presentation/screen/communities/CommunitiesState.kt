package com.example.presentation.screen.communities

import com.example.domain.model.Community

// TODO: rework with a sealed class, add high level states
data class CommunitiesState(
    val communitiesList: List<Community> = listOf()
)
