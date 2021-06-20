package com.nikodem.todo.di

import com.nikodem.todo.repositories.CatApiRepository
import com.nikodem.todo.repositories.CatRepository
import org.koin.dsl.module

val appModule = module {

    single<CatRepository> {
        CatApiRepository(
            catApiService = get()
        )
    }
}
