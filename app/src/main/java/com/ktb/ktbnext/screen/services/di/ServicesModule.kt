package com.ktb.ktbnext.screen.services.di

import com.ktb.ktbnext.screen.services.ServicesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun featureServicesModule() = module {
    viewModel { ServicesViewModel() }
}