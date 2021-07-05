package com.nikodem.todo.di

import com.nikodem.todo.services.CatApiService
import com.nikodem.todo.services.JokesApiService
import com.nikodem.todo.services.WeatherApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val CAT_API_RETROFIT_NAME = "CAT_API_RETROFIT"
const val WEATHER_API_RETROFIT_NAME = "WEATHER_API_RETROFIT"
const val JOKES_API_RETROFIT_NAME = "JOKES_API_RETROFIT"

val networkModule = module {
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        OkHttpClient.Builder().build()
    }

    single(named(CAT_API_RETROFIT_NAME)) {
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
            .build()
    }

    single(named(WEATHER_API_RETROFIT_NAME)) {
        Retrofit.Builder()
            .baseUrl("https://goweather.herokuapp.com/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
            .build()
    }

    single(named(JOKES_API_RETROFIT_NAME)) {
        Retrofit.Builder()
            .baseUrl("https://api.icndb.com/jokes/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
            .build()
    }

    single<CatApiService> {
        get<Retrofit>(named(CAT_API_RETROFIT_NAME)).create(CatApiService::class.java)
    }

    single<WeatherApiService> {
        get<Retrofit>(named(WEATHER_API_RETROFIT_NAME)).create(WeatherApiService::class.java)
    }

    single<JokesApiService> {
        get<Retrofit>(named(JOKES_API_RETROFIT_NAME)).create(JokesApiService::class.java)
    }
}