package com.example.domain.usecase

import com.example.domain.model.Community
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetAllCommunitiesUseCase {
    operator fun invoke(): Flow<List<Community>>
}

internal class GetAllCommunitiesUseCaseMockImpl : GetAllCommunitiesUseCase {
    override fun invoke(): Flow<List<Community>> = allCommunitiesMock
}

private val allCommunitiesMock = flow {
    emit(List(10) {
        Community(
            id = 0,
            title = "Developer meeting",
            description = "",
            image = "https://random.imagecdn.app/500/500",
            meetings = listOf(),
            attendees = listOf(User(id = 0, avatar = "https://random.imagecdn.app/400/400"))
        )
    })
}