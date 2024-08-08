package com.example.domain.repository

import com.example.domain.model.Community
import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MeetRepository {

    fun getAllCommunities(): Flow<List<Community>>

    fun getCommunityById(id: Int): Flow<Community>

    fun getAllMeetings(): Flow<List<Meeting>>

    fun getMeetingById(id: Int): Flow<Meeting>

    fun applyToMeeting(id: Int)

    fun revokeMeetingApplication(id: Int)

    fun sendPhoneNumber()

    fun submitOTP()

    fun isAuthenticated(): Flow<Boolean>
}