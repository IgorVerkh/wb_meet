package com.example.domain.usecase

import com.example.domain.repository.MeetRepositoryStubImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetCommunityByIdTestCase {

    @Test
    fun `should not throw an exception`() = runTest {
        val repository = MeetRepositoryStubImpl()
        val getCommunityByIdUseCase = GetCommunityByIdUseCaseImpl(repository = repository)
        val communityId = 0

        assertDoesNotThrow { getCommunityByIdUseCase(communityId).first() }
    }

    @Test
    fun `community's id should equal requested id`() = runTest {
        val repository = MeetRepositoryStubImpl()
        val getCommunityByIdUseCase = GetCommunityByIdUseCaseImpl(repository = repository)
        val communityId = 0
        val returnedCommunity = getCommunityByIdUseCase(communityId).first()

        assertTrue { returnedCommunity.id == 0 }
    }
}