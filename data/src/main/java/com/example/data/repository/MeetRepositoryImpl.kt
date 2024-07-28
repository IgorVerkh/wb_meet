package com.example.data.repository

import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.repository.MeetRepository
import kotlinx.coroutines.flow.Flow

internal class MeetRepositoryImpl(

) : MeetRepository {
    override suspend fun getAllCommunities(): Flow<List<Community>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCommunityById(id: Int): Flow<Community> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllMeetings(): Flow<List<Meeting>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMeetingById(id: Int): Flow<Meeting> {
        TODO("Not yet implemented")
    }

    override suspend fun applyToMeeting(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun revokeMeetingApplication(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun sendPhoneNumber() {
        TODO("Not yet implemented")
    }

    override suspend fun submitOTP() {
        TODO("Not yet implemented")
    }

}