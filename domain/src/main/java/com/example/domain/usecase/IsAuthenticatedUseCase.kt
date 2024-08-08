package com.example.domain.usecase

import com.example.domain.repository.MeetRepository
import kotlinx.coroutines.flow.Flow

interface IsAuthenticatedUseCase {
    operator fun invoke(): Flow<Boolean>
}

internal class IsAuthenticatedUseCaseImpl(
    private val repository: MeetRepository
) : IsAuthenticatedUseCase {
    override fun invoke(): Flow<Boolean> = repository.isAuthenticated()
}