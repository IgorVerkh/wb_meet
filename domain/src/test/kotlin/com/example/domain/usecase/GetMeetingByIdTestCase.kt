package com.example.domain.usecase

import com.example.domain.repository.MeetRepositoryStubImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetMeetingByIdTestCase {

    @Test
    fun `should not throw an exception`() = runTest {
        val repository = MeetRepositoryStubImpl()
        val getMeetingByIdUseCase = GetMeetingByIdUseCaseImpl(repository = repository)
        val meetingId = 0

        assertDoesNotThrow { getMeetingByIdUseCase(meetingId) }
    }

    @Test
    fun `meeting's id should equal requested id`() = runTest {
        val repository = MeetRepositoryStubImpl()
        val getMeetingByIdUseCase = GetMeetingByIdUseCaseImpl(repository = repository)
        val meetingId = 0
        val returnedMeeting = getMeetingByIdUseCase(meetingId).first()

        assertTrue { returnedMeeting.id == 0 }
    }
}