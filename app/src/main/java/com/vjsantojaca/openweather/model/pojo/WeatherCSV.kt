package com.vjsantojaca.openweather.model.pojo

import java.util.*

data class WeatherCSV(
    val informationWeather: MutableMap<Date, MutableList<InfoWeatherCSV>>
) {
    override fun toString(): String {
        return "WeatherCSV(informationWeather=$informationWeather)"
    }
}

data class InfoWeatherCSV (
    val date :  Date,
    val temp : Float
) {
    override fun toString(): String {
        return "InfoWeatherCSV(date=$date, temp=$temp)"
    }
}
