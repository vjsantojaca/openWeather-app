package com.vjsantojaca.openweather.contract

import com.vjsantojaca.openweather.model.pojo.Weather
import com.vjsantojaca.openweather.model.pojo.WeatherCSV

interface ContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun getWeather()
        fun responseWeather(weather: Weather)
    }

    interface Model {
        fun obtainWeatherAPI()
        fun obtainWeatherCSV(): WeatherCSV?
    }

}