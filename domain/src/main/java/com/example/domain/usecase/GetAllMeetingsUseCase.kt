package com.example.domain.usecase

import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetAllMeetingsUseCase {
    operator fun invoke(): Flow<List<Meeting>>
}

internal class GetAllMeetingsUseCaseMockImpl(

) : GetAllMeetingsUseCase {
    override operator fun invoke(): Flow<List<Meeting>> = allMeetingsMock
}

private val allMeetingsMock = flow {
    emit(List(10) {
        Meeting(
            id = 0,
            title = "Developer meeting",
            date = "13.09.2024",
            city = "Казань",
            image = "https://random.imagecdn.app/500/500",
            tags = listOf("Python", "Junior")
        )
    })
}