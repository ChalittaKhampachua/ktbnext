package com.ktb.ktbnext.screen.home.di

import com.ktb.ktbnext.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun featureHomeModule() = module {
    viewModel { HomeViewModel() }
}