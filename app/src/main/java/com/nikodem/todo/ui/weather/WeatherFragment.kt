package com.nikodem.todo.ui.weather

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import com.nikodem.todo.R
import com.nikodem.todo.databinding.FragmentWeatherBinding
import com.nikodem.todo.utils.BaseFragment


class WeatherFragment :
    BaseFragment<WeatherFragmentViewState, WeatherFragmentViewModel, FragmentWeatherBinding>(
        R.layout.fragment_weather,
        WeatherFragmentViewModel::class
    ) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val simpleSearchView: SearchView = view.findViewById(R.id.searchView) as SearchView

        simpleSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.loadWeather(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // do something when text changes
                return false
            }
        })
    }
}