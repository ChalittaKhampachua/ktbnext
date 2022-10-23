package com.ktb.ktbnext.data.model.account.mapper

import com.ktb.ktbnext.data.model.Mapper
import com.ktb.ktbnext.data.model.account.TransactionEntity
import com.ktb.ktbnext.domain.model.account.Transaction

class TransactionMapper : Mapper<TransactionEntity, List<Transaction>> {
    override fun map(input: TransactionEntity): List<Transaction> {
        with(input) {
            return listOf(
                Transaction(
                    id = 1,
                    name = "Transfer out",
                    date = "20 Nov 2019 - 12:00",
                    amount = "-1,500.00",
                    fromAccountBank = "Krungthai",
                    fromAccountNo = "XXX-X-XX545-1",
                    fromAccountName = "Nils Kizzie"
                ),
                Transaction(
                    id = 2,
                    name = "Transfer PromptPay",
                    date = "20 Nov 2019 - 11:40",
                    amount ="-2,500.00",
                    fromAccountBank ="Krungthai",
                    fromAccountNo = "XXX-X-XX234-0",
                    fromAccountName = "Maram Uaithne"
                ),
                Transaction(
                    id = 3,
                    name = "Transfer in",
                    date = "20 Nov 2019 - 10:30",
                    amount = "+3,500.00",
                    fromAccountBank ="Krungthai",
                    fromAccountNo ="XXX-X-XX984-3",
                    fromAccountName = "Malena Gautstafr"
                )
            )
        }
    }
}