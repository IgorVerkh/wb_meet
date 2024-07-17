package ru.wb.meetings.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.wb.meetings.ui.screen.all_meetings.AllMeetingsViewModel
import ru.wb.meetings.ui.screen.communities.CommunitiesViewModel
import ru.wb.meetings.ui.screen.community_details.CommunityDetailsViewModel
import ru.wb.meetings.ui.screen.meeting_details.MeetingDetailsViewModel
import ru.wb.meetings.ui.screen.miscellaneous.MiscellaneousViewModel
import ru.wb.meetings.ui.screen.my_meetings.MyMeetingsViewModel
import ru.wb.meetings.ui.screen.otp_confirmation.OTPConfirmationViewModel
import ru.wb.meetings.ui.screen.phone_number.PhoneNumberViewModel
import ru.wb.meetings.ui.screen.profile.ProfileViewModel
import ru.wb.meetings.ui.screen.profile_creation.ProfileCreationViewModel

val viewModelModule = module {
    viewModel { AllMeetingsViewModel() }
    viewModel { CommunitiesViewModel() }
    viewModel { CommunityDetailsViewModel() }
    viewModel { MeetingDetailsViewModel() }
    viewModel { MiscellaneousViewModel() }
    viewModel { MyMeetingsViewModel() }
    viewModel { OTPConfirmationViewModel() }
    viewModel { PhoneNumberViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { ProfileCreationViewModel() }
}