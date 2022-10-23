package com.ktb.ktbnext.screen.account.di

import com.ktb.ktbnext.screen.account.AccountViewModel
import com.ktb.ktbnext.screen.account.controller.AccountController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun featureAccountModule() = module {
    viewModel { AccountViewModel() }

    factory { AccountController() }
}