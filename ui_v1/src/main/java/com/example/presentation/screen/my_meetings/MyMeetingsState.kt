package com.example.presentation.screen.my_meetings

import com.example.domain.model.Meeting

internal data class MyMeetingsState(
    val meetings: List<Meeting> = listOf()
)
