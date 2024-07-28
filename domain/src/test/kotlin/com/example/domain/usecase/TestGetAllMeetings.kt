package com.example.domain.usecase

import com.example.domain.di.testModule
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class TestGetAllMeetings : KoinTest {

    private val getAllMeetingsUseCase: GetAllMeetingsUseCase by inject()

    @Test
    fun getAllMeetings() = runTest {
        startKoin {
            modules(testModule)
        }
        getAllMeetingsUseCase.invoke()
    }
}