package ru.wb.meetings.ui.model

data class Meeting(
    val title: String,
    val date: String,
    val city: String,
    val image: Any?,
    val tags: List<String>
)
