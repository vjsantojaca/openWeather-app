package com.vjsantojaca.openweather.model.pojo

import com.vjsantojaca.openweather.model.api.ListWeatherResponse
import com.vjsantojaca.openweather.model.api.WeatherCityResponse

import java.text.SimpleDateFormat
import java.util.*

data class Weather (
    val id : Int?,
    val nameCity : String?,
    val countryCity : String?,
    val informationWeather : List<InfoWeather>
) {
    object ModelMapper {
        fun from(form: WeatherCityResponse) : Weather {
            val informationWeather: MutableList<InfoWeather> = mutableListOf()
            form.list.forEach(fun(value: ListWeatherResponse) {
                val formatter = SimpleDateFormat("yyyy-MM-d HH:mm:ss", Locale.ENGLISH)
                val date = formatter.parse(value.dt_txt)
                val infoWeather = InfoWeather(value.main.temp, date)
                informationWeather.add(infoWeather)
            })

            return Weather(form.city.id, form.city.name, form.city.country, informationWeather)
        }
    }

    override fun toString(): String {
        return "Weather(id=$id, nameCity='$nameCity', countryCity='$countryCity', informationWeather=$informationWeather)"
    }

}


data class InfoWeather (
    val temp : Float?,
    val date : Date?
) {
    override fun toString(): String {
        return "InfoWeather(temp=$temp, date=$date)"
    }
}