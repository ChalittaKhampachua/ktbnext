package com.ktb.ktbnext.domain.usecase.account

import com.ktb.ktbnext.domain.model.account.BookBank
import com.ktb.ktbnext.domain.repository.AccountRepository
import com.ktb.ktbnext.domain.usecase.BaseUseCase

class BookBankUseCase(
    private val repo: AccountRepository
): BaseUseCase<Unit, List<BookBank>> () {
    override suspend fun create(input: Unit): List<BookBank> {
        return repo.getBookBankAll()
    }
}