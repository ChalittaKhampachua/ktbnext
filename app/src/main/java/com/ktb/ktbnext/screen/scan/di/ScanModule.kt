package com.ktb.ktbnext.screen.scan.di

import com.ktb.ktbnext.screen.scan.ScanViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun featureScanModule() = module {
    viewModel { ScanViewModel() }
}