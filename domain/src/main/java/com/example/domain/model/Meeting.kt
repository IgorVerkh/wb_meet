package com.example.domain.model

data class Meeting(
    val id: Int,
    val title: String,
    val date: String,
    val city: String,
    val image: Any?,
    val tags: List<String>,
)
