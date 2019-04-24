package com.vjsantojaca.openweather.di.modules

import android.app.Application
import com.vjsantojaca.openweather.App

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: App) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return baseApp
    }
}