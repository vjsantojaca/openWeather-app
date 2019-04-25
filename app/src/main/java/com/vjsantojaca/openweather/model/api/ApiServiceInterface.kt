package com.vjsantojaca.openweather.model.api

import com.vjsantojaca.openweather.Constants

import retrofit2.Call
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiServiceInterface {

    @GET(Constants.DETAIL_CITY_ENDPOINT)
    fun getWeatherCity() : Call<WeatherCityResponse>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(Constants.URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}