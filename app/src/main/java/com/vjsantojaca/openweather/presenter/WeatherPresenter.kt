package com.vjsantojaca.openweather.presenter

import com.vjsantojaca.openweather.contract.ContractInterface

class WeatherPresenter (_view: ContractInterface.View) : ContractInterface.Presenter {

    private var view: ContractInterface.View = _view

    init {
        view.initView()
    }

    override fun getWeather() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}