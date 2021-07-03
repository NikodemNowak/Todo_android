package com.nikodem.todo.di

import com.nikodem.todo.repositories.CatApiRepository
import com.nikodem.todo.repositories.CatRepository
import com.nikodem.todo.ui.ssecond.SecondFragmentViewModel
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
}
