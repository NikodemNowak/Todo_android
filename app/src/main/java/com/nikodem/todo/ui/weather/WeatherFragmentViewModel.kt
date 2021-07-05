package com.nikodem.todo.ui.weather

import androidx.lifecycle.viewModelScope
import com.nikodem.todo.repositories.WeatherRepository
import com.nikodem.todo.utils.BaseViewModel
import com.nikodem.todo.utils.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class WeatherFragmentViewModel(
    private val weatherRepository: WeatherRepository
) :
    BaseViewModel<WeatherFragmentViewState>(initialState = WeatherFragmentViewState()) {

    fun loadWeather(city: String) {
        updateViewState {
            it.copy(
                isLoading = true
            )
        }
        viewModelScope.launch {
            val weather = withContext(Dispatchers.IO) {
                weatherRepository.getWeather(city)
            }
            updateViewState {
                it.copy(
                    temperature = weather.temperature,
                    wind = weather.wind,
                    description = weather.description,
                    isLoading = false
                )
            }
        }
        Timber.d(currentState.temperature)
    }
}

data class WeatherFragmentViewState(
    val temperature: String = "",
    val wind: String = "",
    val description: String = "",
    override val isLoading: Boolean = false
) : ViewState