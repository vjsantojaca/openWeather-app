package com.vjsantojaca.openweather.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.vjsantojaca.openweather.R
import com.vjsantojaca.openweather.contract.ContractInterface
import com.vjsantojaca.openweather.di.components.DaggerActivityComponent
import com.vjsantojaca.openweather.di.modules.ActivityModule

import javax.inject.Inject

class MainActivity : AppCompatActivity(), ContractInterface.View {

    @Inject
    lateinit var presenter: ContractInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun initView() {
        //NoItemsByNow
    }

    override fun updateViewData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
