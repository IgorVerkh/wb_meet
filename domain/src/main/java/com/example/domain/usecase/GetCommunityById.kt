package com.example.domain.usecase

import com.example.domain.model.Community
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetCommunityById {
    operator fun invoke(id: Int): Flow<Community>
}

internal class GetCommunityByIdMockImpl(

) : GetCommunityById {
    override fun invoke(id: Int): Flow<Community> = mockCommunity
}

private val mockCommunity = flow {
    emit(
        Community(
            id = 0,
            title = "Test Community",
            description = "test description",
            image = "https://random.imagecdn.app/500/500",
            meetings = listOf(),
            attendees = listOf(User(id = 0, avatar = null))
        )
    )
}
