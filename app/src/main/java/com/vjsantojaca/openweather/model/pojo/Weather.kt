package com.vjsantojaca.openweather.model.pojo

import java.util.*

data class Weather (
    val id : Int,
    val nameCity : String,
    val countryCity : String,
    val informationWeather : List<InfoWeather>
)

data class InfoWeather (
    val temp : Int,
    val date : Date
)