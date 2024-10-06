package com.example.ui_v2.di

import org.koin.dsl.module

val uiV2Module = module {
    includes(viewModelModule)
}