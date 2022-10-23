package com.ktb.ktbnext.domain.usecase.account

import com.ktb.ktbnext.domain.model.account.BookBank
import com.ktb.ktbnext.domain.repository.AccountRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import java.util.*

@OptIn(ExperimentalCoroutinesApi::class)
class BookBankUseCaseTest {

    private val accountRepository: AccountRepository = mockk()
    private val bookBankUseCase = BookBankUseCase(accountRepository)

    @Test
    fun `get book bank with successful repository`() = runTest {
        coEvery { accountRepository.getBookBankAll() } returns listOf(
            BookBank(
                id = 1,
                name = "Margaretta Amanda",
                type = "Savings",
                number = "XXX-X-XX555-1",
                isMain = true,
                currentBalance = "69,000.33",
                availableBalance = "68,000.33"
            )
        )
        val result = bookBankUseCase.execute(Unit).getOrNull()
        Assert.assertTrue(result.isNullOrEmpty().not() && result?.get(0)?.id == 1)
    }

    @Test(expected = Exception::class)
    fun `get book bank with failed repository`() = runTest {
        coEvery { accountRepository.getBookBankAll() } throws mockk<Exception>()
        val result = bookBankUseCase.execute(Unit).getOrThrow()
        Assert.assertTrue(result.isEmpty())
    }
}