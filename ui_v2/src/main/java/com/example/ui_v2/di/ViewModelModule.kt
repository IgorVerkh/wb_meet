package com.example.ui_v2.di

import com.example.ui_v2.screen.appointment.appointment_code.AppointmentCodeViewModel
import com.example.ui_v2.screen.appointment.appointment_name.AppointmentNameViewModel
import com.example.ui_v2.screen.appointment.appointment_phone.AppointmentPhoneViewModel
import com.example.ui_v2.screen.interests.InterestsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { InterestsViewModel() }
    viewModel { AppointmentNameViewModel() }
    viewModel { AppointmentPhoneViewModel() }
    viewModel { AppointmentCodeViewModel() }
}