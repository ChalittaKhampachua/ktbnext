package com.ktb.ktbnext.data.repository.account

import com.ktb.ktbnext.data.model.account.BookBankEntity
import com.ktb.ktbnext.data.model.account.TransactionEntity
import com.ktb.ktbnext.data.model.account.mapper.BookBankMapper
import com.ktb.ktbnext.data.model.account.mapper.TransactionMapper
import com.ktb.ktbnext.domain.model.account.BookBank
import com.ktb.ktbnext.domain.model.account.Transaction
import com.ktb.ktbnext.domain.repository.AccountRepository

class AccountRepositoryImpl(
    private val bookBankMapper: BookBankMapper,
    private val transactionMapper: TransactionMapper
) : AccountRepository {
    override suspend fun getBookBankAll(): List<BookBank> {
        return bookBankMapper.map(BookBankEntity())
    }

    override suspend fun getTransactionsAll(): List<Transaction> {
        return transactionMapper.map(TransactionEntity())
    }

}