package com.example.domain.usecase

import com.example.domain.model.Community
import com.example.domain.repository.MeetRepository
import kotlinx.coroutines.flow.Flow

interface GetAllCommunitiesUseCase {
    suspend operator fun invoke(): Flow<List<Community>>
}

internal class GetAllCommunitiesUseCaseImpl(
    private val repository: MeetRepository
) : GetAllCommunitiesUseCase {
    override suspend fun invoke(): Flow<List<Community>> = repository.getAllCommunities()
}