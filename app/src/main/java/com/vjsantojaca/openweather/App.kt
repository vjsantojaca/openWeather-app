package com.vjsantojaca.openweather

import android.app.Application
import com.vjsantojaca.openweather.di.components.ApplicationComponent
import com.vjsantojaca.openweather.di.components.DaggerApplicationComponent
import com.vjsantojaca.openweather.di.modules.ApplicationModule

class App : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}