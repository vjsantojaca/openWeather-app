package com.vjsantojaca.openweather.model

import android.util.Log
import com.vjsantojaca.openweather.contract.ContractInterface
import com.vjsantojaca.openweather.model.api.ApiServiceInterface
import com.vjsantojaca.openweather.model.api.WeatherCityResponse
import com.vjsantojaca.openweather.model.pojo.Weather
import com.vjsantojaca.openweather.presenter.WeatherPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherModel (_presenter : WeatherPresenter) : ContractInterface.Model {

    private var presenter : WeatherPresenter = _presenter

    override fun getWeather() {
        ApiServiceInterface.create().getWeatherCity().enqueue(object : Callback<WeatherCityResponse> {
            override fun onFailure(call: Call<WeatherCityResponse>, t: Throwable) {
                Log.d("VICTOR", "Hubo un problema -> ${t.message}")
            }

            override fun onResponse(call: Call<WeatherCityResponse>, response: Response<WeatherCityResponse>) {
                response.body()?.let {
                    val weather = Weather.ModelMapper.from(it)
                    presenter.responseWeather(weather)
                }
            }

        } )
    }
}