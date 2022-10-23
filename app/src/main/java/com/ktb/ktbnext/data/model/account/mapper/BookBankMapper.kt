package com.ktb.ktbnext.data.model.account.mapper

import com.ktb.ktbnext.data.model.Mapper
import com.ktb.ktbnext.data.model.account.BookBankEntity
import com.ktb.ktbnext.domain.model.account.BookBank

class BookBankMapper : Mapper<BookBankEntity, List<BookBank>> {
    override fun map(input: BookBankEntity): List<BookBank> {
        return listOf(
            BookBank(
                id = 1,
                name = "Margaretta Amanda",
                type = "Savings",
                number = "XXX-X-XX555-1",
                isMain = true,
                currentBalance = "69,000.33",
                availableBalance = "68,000.33"
            ),
            BookBank(
                id = 2,
                name = "Agnes Mariette",
                type = "Current",
                number = "XXX-X-XX565-9",
                isMain = false,
                currentBalance = "5,123.99",
                availableBalance = "5,000.99"
            ),
            BookBank(
                id = 3,
                name = "Eberhard Yarik",
                type = "Savings",
                number = "XXX-X-XX123-8",
                isMain = false,
                currentBalance = "108,000.00",
                availableBalance = "98,000.00"
            ),
            BookBank(
                id = 4,
                name = "Vesta Vasil",
                type = "Savings",
                number = "XXX-X-XX200-3",
                isMain = false,
                currentBalance = "500.98",
                availableBalance = "80.98",
            ),
            BookBank(
                id = 5,
                name = "Jeptha Raymund",
                type = "Payroll",
                number = "XXX-X-XX985-4",
                isMain = false,
                currentBalance = "72,045.00",
                availableBalance = "72,045.00"
            ),
        )
    }
}