package com.vjsantojaca.openweather.contract

interface ContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun getWeather()
    }

    interface Model {
        fun getWeather()
    }

}