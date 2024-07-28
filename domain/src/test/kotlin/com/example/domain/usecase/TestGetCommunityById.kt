package com.example.domain.usecase

import com.example.domain.di.testModule
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class TestGetCommunityById : KoinTest {
    private val getCommunityByIdUseCase : GetCommunityByIdUseCase by inject()

    @Test
    fun `get community by id`() = runTest {
        startKoin {
            modules(testModule)
        }
        getCommunityByIdUseCase.invoke(0)
    }
}