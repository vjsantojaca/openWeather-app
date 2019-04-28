package com.vjsantojaca.openweather.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.vjsantojaca.openweather.R
import com.vjsantojaca.openweather.contract.ContractInterface
import kotlinx.android.synthetic.main.fragment_list.*

import javax.inject.Inject

class ListFragmentAPI: Fragment() {
    @Inject
    lateinit var presenter: ContractInterface.Presenter

    private lateinit var rootView: View

    fun newInstance(): ListFragmentAPI {
        return ListFragmentAPI()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}