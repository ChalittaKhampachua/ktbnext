package com.ktb.ktbnext.domain.usecase.account

import com.ktb.ktbnext.domain.model.account.Transaction
import com.ktb.ktbnext.domain.repository.AccountRepository
import com.ktb.ktbnext.domain.usecase.BaseUseCase

class TransactionUseCase(
    private val repo: AccountRepository
): BaseUseCase<Unit, List<Transaction>> () {
    override suspend fun create(input: Unit): List<Transaction> {
        return repo.getTransactionsAll()
    }
}