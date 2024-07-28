package com.example.domain.di

import org.koin.dsl.module

internal val testModule = module {
    includes(testUseCaseModule, testRepositoryModule)
}