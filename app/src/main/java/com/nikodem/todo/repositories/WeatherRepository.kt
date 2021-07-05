package com.nikodem.todo.repositories

import com.nikodem.todo.services.WeatherApiService
import com.nikodem.todo.services.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(city: String): WeatherResponse
}

class WeatherApiRepository(private val weatherApiService: WeatherApiService) : WeatherRepository {
    override suspend fun getWeather(city: String): WeatherResponse {
        return weatherApiService.getWeather(city)
    }
}