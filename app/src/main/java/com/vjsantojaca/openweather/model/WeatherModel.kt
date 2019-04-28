package com.vjsantojaca.openweather.model

import android.util.Log
import com.vjsantojaca.openweather.App

import com.vjsantojaca.openweather.Constants
import com.vjsantojaca.openweather.contract.ContractInterface
import com.vjsantojaca.openweather.model.api.ApiServiceInterface
import com.vjsantojaca.openweather.model.api.WeatherCityResponse
import com.vjsantojaca.openweather.model.pojo.InfoWeatherCSV
import com.vjsantojaca.openweather.model.pojo.Weather
import com.vjsantojaca.openweather.model.pojo.WeatherCSV
import com.vjsantojaca.openweather.presenter.WeatherPresenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.*

class WeatherModel (_presenter : WeatherPresenter) : ContractInterface.Model {

    private var presenter : WeatherPresenter = _presenter

    override fun obtainWeatherAPI() {
        ApiServiceInterface.create().getWeatherCity().enqueue(object : Callback<WeatherCityResponse> {
            override fun onFailure(call: Call<WeatherCityResponse>, t: Throwable) {
                Log.d(Constants.TAG, "[onFailure] Throwable -> ${t.message}")
            }

            override fun onResponse(call: Call<WeatherCityResponse>, response: Response<WeatherCityResponse>) {
                Log.d(Constants.TAG, "[onResponse] It is ok")
                response.body()?.let {
                    val weather = Weather.ModelMapper.from(it)
                    presenter.responseWeather(weather)
                }
            }

        } )
    }

    override fun obtainWeatherCSV() : WeatherCSV? {
        var fileReader : BufferedReader? = null
        val formatter = SimpleDateFormat("yyyy-MM-d HH:mm:ss", Locale.ENGLISH)
        val informationWeather : MutableList<InfoWeatherCSV> = mutableListOf()
        try {
            var line: String?
            fileReader = BufferedReader(InputStreamReader(App.instance.getAssets().open(("openWeather.csv"))))
            line = fileReader.readLine()
            while (line != null) {
                val tokens = line.split(";")
                if (tokens.size > 0) {
                    val infoWeatherCSV = InfoWeatherCSV(
                        formatter.parse(tokens[0]),
                        tokens[1].toFloat()
                    )
                    Log.d(Constants.TAG, "[obtainWeatherCSV] informationWeather -> ${infoWeatherCSV}")
                    informationWeather.add(infoWeatherCSV)
                }
                line = fileReader.readLine()
            }
            return WeatherCSV(informationWeather)

        } catch (e: Exception) {
            Log.d(Constants.TAG, "[obtainWeatherCSV] Exception -> ${e.printStackTrace()}")
            return null
        } finally {
            try {
                fileReader!!.close()
            } catch (e: IOException) {
                Log.d(Constants.TAG, "[obtainWeatherCSV] Exception -> ${e.printStackTrace()}")
            }
        }
    }
}