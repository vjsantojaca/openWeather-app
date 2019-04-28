package com.vjsantojaca.openweather.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

import com.vjsantojaca.openweather.App
import com.vjsantojaca.openweather.Constants
import com.vjsantojaca.openweather.R
import com.vjsantojaca.openweather.model.pojo.WeatherCSV

import kotlinx.android.synthetic.main.fragment_list.*

class ListFragmentCSV: Fragment() {

    private lateinit var weatherCSV : WeatherCSV
    val tableLayout by lazy { TableLayout(App.instance) }

    fun newInstance(weatherCSV: WeatherCSV?): ListFragmentAPI {
        this.weatherCSV = weatherCSV!!
        return ListFragmentAPI()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lp = TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        tableLayout.apply {
            layoutParams = lp
            isShrinkAllColumns = true
        }

        weatherCSV.informationWeather.forEach {
            val row = TableRow(App.instance)
            row.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            it.value.forEach() {
                val textViewInfo = TextView(App.instance)
                textViewInfo.apply {
                    layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT)
                    text = "${it.date} + ${it.temp}"
                }
                row.addView(textViewInfo)
            }
            tableLayout.addView(row)
        }
        linearLayoutFragment.addView(tableLayout)
        Log.d(Constants.TAG, "PRUEBA")
    }
}