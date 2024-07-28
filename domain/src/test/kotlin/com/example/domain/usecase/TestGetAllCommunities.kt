package com.example.domain.usecase

import com.example.domain.di.testModule
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class TestGetAllCommunities : KoinTest {
    private val getAllCommunitiesUseCase : GetAllCommunitiesUseCase by inject()

    @Test
    fun getAllCommunities() = runTest {
        startKoin {
            modules(testModule)
        }
        getAllCommunitiesUseCase.invoke()
    }
}