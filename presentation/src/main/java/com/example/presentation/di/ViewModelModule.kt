package com.example.presentation.di

import com.example.presentation.screen.all_meetings.AllMeetingsViewModel
import com.example.presentation.screen.communities.CommunitiesViewModel
import com.example.presentation.screen.community_details.CommunityDetailsViewModel
import com.example.presentation.screen.meeting_details.MeetingDetailsViewModel
import com.example.presentation.screen.miscellaneous.MiscellaneousViewModel
import com.example.presentation.screen.my_meetings.MyMeetingsViewModel
import com.example.presentation.screen.otp_confirmation.OTPConfirmationViewModel
import com.example.presentation.screen.phone_number.PhoneNumberViewModel
import com.example.presentation.screen.profile.ProfileViewModel
import com.example.presentation.screen.profile_creation.ProfileCreationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AllMeetingsViewModel(getAllMeetingsUseCase = get()) }
    viewModel { CommunitiesViewModel(getAllCommunitiesUseCase = get()) }
    viewModel { CommunityDetailsViewModel(getCommunityById = get()) }
    viewModel { MeetingDetailsViewModel() }
    viewModel { MiscellaneousViewModel() }
    viewModel { MyMeetingsViewModel() }
    viewModel { OTPConfirmationViewModel() }
    viewModel { PhoneNumberViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { ProfileCreationViewModel() }
}