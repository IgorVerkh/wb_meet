package com.example.domain.usecase

import com.example.domain.repository.MeetRepositoryStubImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetAllCommunitiesTestCase {

    @Test
    fun `should not throw an exception`() = runTest {
        val repository = MeetRepositoryStubImpl()
        val getAllCommunitiesUseCase = GetAllCommunitiesUseCaseImpl(repository = repository)

        assertDoesNotThrow { getAllCommunitiesUseCase().first() }
    }

    @Test
    fun `communities list should not contain duplicates`() = runTest {
        val repository = MeetRepositoryStubImpl()
        val getAllCommunitiesUseCase = GetAllCommunitiesUseCaseImpl(repository = repository)
        val communities = getAllCommunitiesUseCase().first()

        assertTrue { communities.size == communities.toSet().size }
    }
}