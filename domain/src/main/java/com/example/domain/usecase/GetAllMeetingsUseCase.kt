package com.example.domain.usecase

import com.example.domain.model.Meeting
import com.example.domain.repository.MeetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetAllMeetingsUseCase {
    suspend operator fun invoke(): Flow<List<Meeting>>
}

internal class GetAllMeetingsUseCaseImpl(
    private val repository: MeetRepository
) : GetAllMeetingsUseCase {
    override suspend fun invoke(): Flow<List<Meeting>> = repository.getAllMeetings()
}