package com.ktb.ktbnext.screen.account.model

import com.ktb.ktbnext.domain.model.account.BookBank
import com.ktb.ktbnext.domain.model.account.Transaction

data class AccountUI(
    val bookBankList: List<BookBank>?,
    val transactionList: List<Transaction>?
)
