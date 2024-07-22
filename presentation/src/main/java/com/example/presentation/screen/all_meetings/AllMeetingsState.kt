package com.example.presentation.screen.all_meetings

import com.example.domain.model.Meeting

// TODO: rework with a sealed class, add high level states
data class AllMeetingsState(
    val meetingsList: List<Meeting> = listOf()
)
