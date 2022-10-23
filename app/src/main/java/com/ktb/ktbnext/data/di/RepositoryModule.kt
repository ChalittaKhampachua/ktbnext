package com.ktb.ktbnext.data.di

import com.ktb.ktbnext.data.repository.account.AccountRepositoryImpl
import com.ktb.ktbnext.domain.repository.AccountRepository
import org.koin.dsl.module

fun createRepositoryModule() = module {
    //Repo
    single<AccountRepository> { AccountRepositoryImpl(get(), get()) }
}