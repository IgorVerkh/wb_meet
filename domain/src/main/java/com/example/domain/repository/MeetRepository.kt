package com.example.domain.repository

import com.example.domain.model.Community
import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.Flow

interface MeetRepository {

    suspend fun getAllCommunities(): Flow<List<Community>>

    suspend fun getCommunityById(id: Int): Flow<Community>

    suspend fun getAllMeetings(): Flow<List<Meeting>>

    suspend fun getMeetingById(id: Int): Flow<Meeting>

    suspend fun applyToMeeting(id: Int)

    suspend fun revokeMeetingApplication(id: Int)

    suspend fun sendPhoneNumber()

    suspend fun submitOTP()
}