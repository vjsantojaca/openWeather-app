package com.vjsantojaca.openweather.presenter

import com.vjsantojaca.openweather.contract.ContractInterface
import com.vjsantojaca.openweather.model.WeatherModel
import com.vjsantojaca.openweather.model.pojo.Weather

class WeatherPresenter : ContractInterface.Presenter {

    private lateinit var view : ContractInterface.View
    private var model : ContractInterface.Model = WeatherModel(this)

    override fun attach(view: ContractInterface.View) {
        this.view = view
        view.initView()
    }

    override fun getWeather() {
        model.obtainWeatherAPI()
    }

    override fun responseWeather(weather: Weather) {
    }


    override fun getInfoCSV() {
        val weatherCSV = model.obtainWeatherCSV()
    }

}