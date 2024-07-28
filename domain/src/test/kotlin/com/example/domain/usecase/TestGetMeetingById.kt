package com.example.domain.usecase

import com.example.domain.di.testModule
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class TestGetMeetingById : KoinTest {

    private val getMeetingByIdUseCase: GetMeetingByIdUseCase by inject()

    @Test
    fun getMeetingById() = runTest {
        startKoin {
            modules(testModule)
        }
        getMeetingByIdUseCase.invoke(0)
    }
}