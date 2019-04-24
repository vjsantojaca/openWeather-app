package com.vjsantojaca.openweather.di.components

import com.vjsantojaca.openweather.App
import com.vjsantojaca.openweather.di.modules.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: App)

}