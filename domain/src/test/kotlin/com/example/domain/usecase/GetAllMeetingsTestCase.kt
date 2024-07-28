package com.example.domain.usecase

import com.example.domain.repository.MeetRepositoryStubImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetAllMeetingsTestCase {

    @Test
    fun `should not throw an exception`() = runTest {
        val repository = MeetRepositoryStubImpl()
        val getAllMeetingsUseCase = GetAllMeetingsUseCaseImpl(repository = repository)

        assertDoesNotThrow { getAllMeetingsUseCase().first() }
    }

    @Test
    fun `meetings list should not contain duplicates`() = runTest {
        val repository = MeetRepositoryStubImpl()
        val getAllMeetingsUseCase = GetAllMeetingsUseCaseImpl(repository = repository)
        val meetings = getAllMeetingsUseCase().first()

        assertTrue { meetings.size == meetings.toSet().size }
    }
}