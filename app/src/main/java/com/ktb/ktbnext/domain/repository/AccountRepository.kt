package com.ktb.ktbnext.domain.repository

import com.ktb.ktbnext.domain.model.account.BookBank
import com.ktb.ktbnext.domain.model.account.Transaction

interface AccountRepository {
    suspend fun getBookBankAll() : List<BookBank>
    suspend fun getTransactionsAll() : List<Transaction>
}