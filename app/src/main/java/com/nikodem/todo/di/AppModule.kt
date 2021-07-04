package com.nikodem.todo.di

import com.nikodem.todo.repositories.CatApiRepository
import com.nikodem.todo.repositories.CatRepository
import com.nikodem.todo.ui.main.MainFragmentViewModel
import com.nikodem.todo.ui.ssecond.SecondFragmentViewModel
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
}
