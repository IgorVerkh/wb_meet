package com.example.domain.model

data class Community(
    val id: Int,
    val title: String,
    val description: String,
    val image: Any?,
    val meetings: List<Meeting>,
    val attendees: List<User>,
)
