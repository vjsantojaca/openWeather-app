package com.vjsantojaca.openweather.contract

import com.vjsantojaca.openweather.model.pojo.Weather
import com.vjsantojaca.openweather.model.pojo.WeatherCSV

interface ContractInterface {

    interface View {
        fun initView()
        fun updateViewData(weather: Weather)
    }

    interface Presenter {
        fun attach(view : View)
        fun getWeather()
        fun getInfoCSV() : WeatherCSV?
        fun responseWeather(weather: Weather)
    }

    interface Model {
        fun obtainWeatherAPI()
        fun obtainWeatherCSV(): WeatherCSV?
    }

}