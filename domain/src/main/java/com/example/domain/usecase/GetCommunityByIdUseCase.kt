package com.example.domain.usecase

import com.example.domain.model.Community
import com.example.domain.model.User
import com.example.domain.repository.MeetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetCommunityByIdUseCase {
    suspend operator fun invoke(id: Int): Flow<Community>
}

internal class GetCommunityByIdUseCaseImpl(
    private val repository: MeetRepository
) : GetCommunityByIdUseCase {
    override suspend fun invoke(id: Int): Flow<Community> = repository.getCommunityById(id = id)
}

