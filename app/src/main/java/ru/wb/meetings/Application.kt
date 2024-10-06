package ru.wb.meetings

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.presentation.di.presentationModule
import com.example.ui_v2.di.uiV2Module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(
                uiV2Module,
                domainModule,
                dataModule
            )
        }
    }
}