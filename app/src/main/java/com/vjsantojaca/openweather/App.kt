package com.vjsantojaca.openweather

import android.app.Application

import com.vjsantojaca.openweather.di.components.ApplicationComponent
import com.vjsantojaca.openweather.di.components.DaggerApplicationComponent

class App : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: App private set
    }
}