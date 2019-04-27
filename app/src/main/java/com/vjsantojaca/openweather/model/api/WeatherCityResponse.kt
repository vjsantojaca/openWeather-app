package com.vjsantojaca.openweather.model.api

class WeatherCityResponse (
    val list : List<ListWeatherResponse>,
    val city : CityWeatherResponse
)

class CityWeatherResponse (
    val id : Int,
    val name : String,
    val country : String
)

class ListWeatherResponse (
    val main : MainWeatherResponse,
    val dt_txt : String
)

class MainWeatherResponse (
    val temp : Float
)