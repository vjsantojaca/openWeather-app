package com.vjsantojaca.openweather.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.vjsantojaca.openweather.R
import com.vjsantojaca.openweather.contract.ContractInterface
import com.vjsantojaca.openweather.presenter.WeatherPresenter

class MainActivity : AppCompatActivity(), ContractInterface.View {

    private var presenter: WeatherPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = WeatherPresenter(this)
    }

    override fun initView() {
        //NoItemsByNow
    }

    override fun updateViewData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
