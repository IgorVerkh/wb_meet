package com.example.data

import com.example.data.model.DataCommunity
import com.example.data.model.DataMeeting
import com.example.domain.model.Community
import com.example.domain.model.Meeting

internal fun DataCommunity.toCommunity(): Community {
    return Community(
        id = id,
        title = title,
        description = description,
        image = image,
        meetings = meetings,
        attendees = attendees
    )
}

internal fun DataMeeting.toMeeting(): Meeting {
    return Meeting(
        id = id,
        title = title,
        date = date,
        city = city,
        image = image,
        tags = tags
    )
}