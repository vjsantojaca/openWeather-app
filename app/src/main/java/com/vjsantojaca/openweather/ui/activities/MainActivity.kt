package com.vjsantojaca.openweather.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.View
import android.widget.FrameLayout

import com.vjsantojaca.openweather.Constants
import com.vjsantojaca.openweather.R
import com.vjsantojaca.openweather.contract.ContractInterface
import com.vjsantojaca.openweather.di.components.DaggerActivityComponent
import com.vjsantojaca.openweather.di.modules.ActivityModule
import com.vjsantojaca.openweather.model.pojo.Weather
import com.vjsantojaca.openweather.ui.fragments.ListFragmentAPI
import com.vjsantojaca.openweather.ui.fragments.ListFragmentCSV
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject

class MainActivity : AppCompatActivity(), ContractInterface.View {

    @Inject
    lateinit var presenter: ContractInterface.Presenter
    var tabLayout: TabLayout? = null
    var frameLayout: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()
        presenter.attach(this)

        tabLayout = findViewById(R.id.tabs_main)
        frameLayout = findViewById(R.id.frame)

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> initViewAPI()
                    1 -> showListFragmentCSV()
                }
            }
        })
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    fun showListFragmentAPI(weather :  Weather) {
        showProgress(false)
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .replace(R.id.frame, ListFragmentAPI().newInstance(weather), Constants.TAG)
            .commit()
    }

    fun showListFragmentCSV() {
        var weatherCSV = presenter.getInfoCSV()
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .replace(R.id.frame, ListFragmentCSV().newInstance(weatherCSV), Constants.TAG)
            .commit()
    }

    override fun initViewAPI() {
        showProgress(true)
        presenter.getWeather()
    }

    override fun updateFragmentWeatherAPI(weather: Weather) {
        showListFragmentAPI(weather)
    }

    fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}
