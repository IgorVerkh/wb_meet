package com.example.domain.usecase

import com.example.domain.model.Meeting
import com.example.domain.repository.MeetRepository
import kotlinx.coroutines.flow.Flow

interface GetMeetingByIdUseCase {
    operator fun invoke(id: Int): Flow<Meeting>
}

internal class GetMeetingByIdUseCaseImpl(
    private val repository: MeetRepository
) : GetMeetingByIdUseCase {
    override fun invoke(id: Int): Flow<Meeting> = repository.getMeetingById(id = id)
}