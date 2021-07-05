package com.nikodem.todo.di

import com.nikodem.todo.repositories.*
import com.nikodem.todo.ui.jokes.JokesFragmentViewModel
import com.nikodem.todo.ui.main.MainFragmentViewModel
import com.nikodem.todo.ui.second.SecondFragmentViewModel
import com.nikodem.todo.ui.weather.WeatherFragmentViewModel
import com.nikodem.todo.utils.ContentProvider
import com.nikodem.todo.utils.ContentProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single<CatRepository> {
        CatApiRepository(
            catApiService = get()
        )
    }

    single {
        SecondFragmentViewModel(
            catRepository = get()
        )
    }

    single<ContentProvider> {
        ContentProviderImpl(
            context = androidContext()
        )
    }

    single {
        MainFragmentViewModel(
            contentProvider = get()
        )
    }

    single<WeatherRepository> {
        WeatherApiRepository(
            weatherApiService = get()
        )
    }


    single {
        WeatherFragmentViewModel(
            weatherRepository = get()
        )
    }

    single<JokesRepository> {
        JokesApiRepository(
            jokesApiService = get()
        )
    }

    single {
        JokesFragmentViewModel(
            jokesRepository = get()
        )
    }
}
