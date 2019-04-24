package com.vjsantojaca.openweather

import android.app.Application
import com.vjsantojaca.openweather.di.components.ApplicationComponent
import com.vjsantojaca.openweather.di.components.DaggerMainComponent

class App : Application() {
    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        initializeInjector()
    }

    fun initializeInjector() {
        component = DaggerMainComponent.create();
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }
}