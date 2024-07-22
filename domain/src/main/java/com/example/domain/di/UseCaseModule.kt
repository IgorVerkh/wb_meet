package com.example.domain.di

import com.example.domain.usecase.GetAllCommunitiesUseCase
import com.example.domain.usecase.GetAllCommunitiesUseCaseMockImpl
import com.example.domain.usecase.GetAllMeetingsUseCaseMockImpl
import com.example.domain.usecase.GetAllMeetingsUseCase
import com.example.domain.usecase.GetCommunityById
import com.example.domain.usecase.GetCommunityByIdMockImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetAllMeetingsUseCase> { GetAllMeetingsUseCaseMockImpl() }
    factory<GetAllCommunitiesUseCase> { GetAllCommunitiesUseCaseMockImpl() }
    factory<GetCommunityById> { GetCommunityByIdMockImpl() }
}