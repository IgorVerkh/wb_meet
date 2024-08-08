package com.example.domain.di

import com.example.domain.usecase.GetAllCommunitiesUseCase
import com.example.domain.usecase.GetAllCommunitiesUseCaseImpl
import com.example.domain.usecase.GetAllMeetingsUseCase
import com.example.domain.usecase.GetAllMeetingsUseCaseImpl
import com.example.domain.usecase.GetCommunityByIdUseCase
import com.example.domain.usecase.GetCommunityByIdUseCaseImpl
import com.example.domain.usecase.GetMeetingByIdUseCase
import com.example.domain.usecase.GetMeetingByIdUseCaseImpl
import com.example.domain.usecase.IsAuthenticatedUseCase
import com.example.domain.usecase.IsAuthenticatedUseCaseImpl
import org.koin.dsl.module

internal val useCaseModule = module {
    factory<GetAllMeetingsUseCase> {
        GetAllMeetingsUseCaseImpl(repository = get())
    }
    factory<GetMeetingByIdUseCase> {
        GetMeetingByIdUseCaseImpl(repository = get())
    }
    factory<GetAllCommunitiesUseCase> {
        GetAllCommunitiesUseCaseImpl(repository = get())
    }
    factory<GetCommunityByIdUseCase> {
        GetCommunityByIdUseCaseImpl(repository = get())
    }
    factory<IsAuthenticatedUseCase> {
        IsAuthenticatedUseCaseImpl(repository = get())
    }
}