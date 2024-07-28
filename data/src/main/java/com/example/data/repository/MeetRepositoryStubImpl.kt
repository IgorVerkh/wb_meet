package com.example.data.repository

import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.repository.MeetRepository
import com.example.data.model.mockedCommunities
import com.example.data.model.mockedMeetings
import com.example.data.toCommunity
import com.example.data.toMeeting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MeetRepositoryStubImpl : MeetRepository {
    override fun getAllCommunities(): Flow<List<Community>> = flow {
        emit(mockedCommunities.map { dataCommunity -> dataCommunity.toCommunity()})
    }

    override fun getCommunityById(id: Int): Flow<Community> = flow {
        emit(mockedCommunities.find { it.id == id }!!.toCommunity())
    }

    override fun getAllMeetings(): Flow<List<Meeting>> = flow {
        emit(mockedMeetings.map { dataMeeting -> dataMeeting.toMeeting() })
    }

    override fun getMeetingById(id: Int): Flow<Meeting> = flow {
        emit(mockedMeetings.find { it.id == id }!!.toMeeting())
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
}