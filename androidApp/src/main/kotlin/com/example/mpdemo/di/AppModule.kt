package com.example.mpdemo.di

import com.example.mpdemo.repository.CatFactRepository
import com.example.mpdemo.ui.cat_fact.CatFactScreenVM
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { CatFactRepository() }
    viewModel { CatFactScreenVM(get()) }
}
