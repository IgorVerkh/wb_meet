package com.example.domain.usecase

import com.example.domain.di.testModule
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.assertTrue

class TestGetMeetingById : KoinTest {

    private val getMeetingByIdUseCase: GetMeetingByIdUseCase by inject()

    @BeforeEach
    fun setUp() {
        startKoin { modules(testModule) }
    }

    @AfterEach
    fun finishKoin() {
        stopKoin()
    }

    @Test
    fun `get meeting by id`() = runTest {
        getMeetingByIdUseCase(0)
    }

    @Test
    fun `id is valid`() = runTest {
        assertTrue { getMeetingByIdUseCase(0).first().id == 0 }
    }
}