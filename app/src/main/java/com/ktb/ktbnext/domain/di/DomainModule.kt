package com.ktb.ktbnext.domain.di

import com.ktb.ktbnext.domain.usecase.account.BookBankUseCase
import com.ktb.ktbnext.domain.usecase.account.TransactionUseCase
import org.koin.dsl.module

fun createDomainModule() = module {
    //useCase
    single { BookBankUseCase(get()) }
    single { TransactionUseCase(get()) }
}