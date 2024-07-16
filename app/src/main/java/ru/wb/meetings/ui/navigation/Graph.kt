package ru.wb.meetings.ui.navigation

sealed class Graph(val route: String) {
    data object AuthGraph : Graph("auth_graph")
    data object MeetingsGraph : Graph("meetings_graph")
    data object CommunitiesGraph : Graph("communities_graph")
    data object MiscGraph : Graph("misc_graph")
}