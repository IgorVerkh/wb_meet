package com.example.data.di

import com.example.domain.repository.MeetRepository
import com.example.data.repository.MeetRepositoryStubImpl
import org.koin.dsl.module

internal val repositoryModule = module {
    single<MeetRepository> { MeetRepositoryStubImpl() }
}