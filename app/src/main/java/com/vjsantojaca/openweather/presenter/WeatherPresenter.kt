package com.vjsantojaca.openweather.presenter

import android.util.Log
import com.vjsantojaca.openweather.contract.ContractInterface
import com.vjsantojaca.openweather.model.WeatherModel
import com.vjsantojaca.openweather.model.pojo.Weather

class WeatherPresenter (_view: ContractInterface.View) : ContractInterface.Presenter {

    private var view : ContractInterface.View = _view
    private var model : ContractInterface.Model = WeatherModel(this)

    init {
        //view.initView()
    }

    override fun getWeather() {
        model.obtainWeatherAPI()
    }

    override fun responseWeather(weather: Weather) {
    }

}