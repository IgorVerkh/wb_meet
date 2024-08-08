package com.example.data.repository

import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.repository.MeetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

internal class MeetRepositoryImpl(

) : MeetRepository {
    override fun getAllCommunities(): Flow<List<Community>> {
        TODO("Not yet implemented")
    }

    override fun getCommunityById(id: Int): Flow<Community> {
        TODO("Not yet implemented")
    }

    override fun getAllMeetings(): Flow<List<Meeting>> {
        TODO("Not yet implemented")
    }

    override fun getMeetingById(id: Int): Flow<Meeting> {
        TODO("Not yet implemented")
    }

    override fun applyToMeeting(id: Int) {
        TODO("Not yet implemented")
    }

    override fun revokeMeetingApplication(id: Int) {
        TODO("Not yet implemented")
    }

    override fun sendPhoneNumber() {
        TODO("Not yet implemented")
    }

    override fun submitOTP() {
        TODO("Not yet implemented")
    }

    override fun isAuthenticated(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

}