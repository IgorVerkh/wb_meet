package com.example.domain.di

import com.example.domain.repository.MeetRepository
import com.example.domain.repository.MeetRepositoryStubImpl
import org.koin.dsl.module

internal val testRepositoryModule = module {
    single<MeetRepository> { MeetRepositoryStubImpl() }
}