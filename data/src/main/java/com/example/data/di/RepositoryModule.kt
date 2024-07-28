package com.example.data.di

import com.example.domain.repository.MeetRepository
import com.example.data.repository.MeetRepositoryFakeImpl
import org.koin.dsl.module

internal val repositoryModule = module {
    single<MeetRepository> { MeetRepositoryFakeImpl() }
}