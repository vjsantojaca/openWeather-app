package com.vjsantojaca.openweather.di.modules

import android.app.Activity

import com.vjsantojaca.openweather.contract.ContractInterface
import com.vjsantojaca.openweather.presenter.WeatherPresenter

import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): ContractInterface.Presenter {
        return WeatherPresenter()
    }
}