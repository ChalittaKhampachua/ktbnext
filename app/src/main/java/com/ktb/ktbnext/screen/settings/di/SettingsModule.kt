package com.ktb.ktbnext.screen.settings.di

import com.ktb.ktbnext.screen.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun featureSettingsModule() = module {
    viewModel { SettingsViewModel() }
}