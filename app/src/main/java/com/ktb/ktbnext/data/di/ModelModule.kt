package com.ktb.ktbnext.data.di

import com.ktb.ktbnext.data.model.account.mapper.BookBankMapper
import com.ktb.ktbnext.data.model.account.mapper.TransactionMapper
import org.koin.dsl.module

fun createModelModule() = module {
    //Mapper
    single { BookBankMapper() }
    single { TransactionMapper() }
}