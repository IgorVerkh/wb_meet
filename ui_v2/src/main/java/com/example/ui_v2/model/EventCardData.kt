package com.example.ui_v2.model

data class EventCardData(
    val id: Int,
    val title: String,
    val image: Any?,
    val date: String,
    val address: String,
    val tags: List<String>,
)
