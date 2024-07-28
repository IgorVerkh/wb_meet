package com.example.domain.usecase

import com.example.domain.model.Community
import com.example.domain.repository.MeetRepository
import kotlinx.coroutines.flow.Flow

interface GetCommunityByIdUseCase {
    operator fun invoke(id: Int): Flow<Community>
}

internal class GetCommunityByIdUseCaseImpl(
    private val repository: MeetRepository
) : GetCommunityByIdUseCase {
    override fun invoke(id: Int): Flow<Community> = repository.getCommunityById(id = id)
}

