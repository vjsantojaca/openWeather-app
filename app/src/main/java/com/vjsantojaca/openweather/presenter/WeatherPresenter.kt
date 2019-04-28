package com.vjsantojaca.openweather.presenter

import com.vjsantojaca.openweather.contract.ContractInterface
import com.vjsantojaca.openweather.model.WeatherModel
import com.vjsantojaca.openweather.model.pojo.Weather
import com.vjsantojaca.openweather.model.pojo.WeatherCSV

class WeatherPresenter : ContractInterface.Presenter {

    private lateinit var view : ContractInterface.View
    private var model : ContractInterface.Model = WeatherModel(this)

    override fun attach(view: ContractInterface.View) {
        this.view = view
        view.initView()
        model.obtainWeatherAPI()
    }

    override fun getWeather() {
        model.obtainWeatherAPI()
    }

    override fun responseWeather(weather: Weather) {
        view.updateViewData(weather)
    }


    override fun getInfoCSV() : WeatherCSV? {
        return model.obtainWeatherCSV()
    }

}