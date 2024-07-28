package com.example.domain.model

data class DataCommunity(
    val id: Int,
    val title: String,
    val description: String,
    val image: Any?,
    val meetings: List<Int>,
    val attendees: List<Int>,
)

internal val mockedCommunities = listOf(
    DataCommunity(
        id = 0,
        title = "Community 1",
        description = "Description",
        image = "https://random.imagecdn.app/310/310",
        meetings = listOf(0, 5),
        attendees = listOf(0, 1, 2, 3, 4)
    ),
    DataCommunity(
        id = 1,
        title = "Community two",
        description = "Description",
        image = "https://random.imagecdn.app/320/320",
        meetings = listOf(1),
        attendees = listOf(0, 4)
    ),
    DataCommunity(
        id = 2,
        title = "Community 0",
        description = "Description",
        image = "https://random.imagecdn.app/330/330",
        meetings = listOf(2, 3, 4),
        attendees = listOf(0, 1, 2)
    )
)
