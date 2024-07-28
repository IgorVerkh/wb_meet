package com.example.data.model

internal data class DataMeeting(
    val id: Int,
    val title: String,
    val date: String,
    val city: String,
    val image: Any?,
    val tags: List<String>,
)

internal val mockedMeetings = listOf(
    DataMeeting(
        id = 0,
        title = "Developer meeting",
        date = "13.09.2024",
        city = "Казань",
        image = "https://random.imagecdn.app/400/400",
        tags = listOf("Python", "Junior")
    ),
    DataMeeting(
        id = 1,
        title = "Developer meeting",
        date = "13.09.2024",
        city = "Казань",
        image = "https://random.imagecdn.app/410/410",
        tags = listOf("Python", "Junior")
    ),
    DataMeeting(
        id = 2,
        title = "Developer meeting",
        date = "13.09.2024",
        city = "Казань",
        image = "https://random.imagecdn.app/420/420",
        tags = listOf("Python", "Junior")
    ),
    DataMeeting(
        id = 3,
        title = "Developer meeting",
        date = "13.09.2024",
        city = "Казань",
        image = "https://random.imagecdn.app/430/430",
        tags = listOf("Python", "Junior")
    ),
    DataMeeting(
        id = 4,
        title = "Developer meeting",
        date = "13.09.2024",
        city = "Казань",
        image = "https://random.imagecdn.app/440/440",
        tags = listOf("Python", "Junior")
    ),
    DataMeeting(
        id = 5,
        title = "Developer meeting",
        date = "13.09.2024",
        city = "Казань",
        image = "https://random.imagecdn.app/450/450",
        tags = listOf("Python", "Junior")
    )
)

