package com.vjsantojaca.openweather.di.components

import com.vjsantojaca.openweather.di.modules.ActivityModule
import com.vjsantojaca.openweather.ui.activities.MainActivity

import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}