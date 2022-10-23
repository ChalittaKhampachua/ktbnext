package com.ktb.ktbnext.domain.usecase.account

import com.ktb.ktbnext.domain.model.account.Transaction
import com.ktb.ktbnext.domain.repository.AccountRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TransactionUseCaseTest {

    private val accountRepository: AccountRepository = mockk()
    private val transactionUseCase = TransactionUseCase(accountRepository)

    @Test
    fun `get transaction with successful repository`() = runTest {
        coEvery { accountRepository.getTransactionsAll() } returns listOf(
            Transaction(
                id = 3,
                name = "Transfer in",
                date = "20 Nov 2019 - 10:30",
                amount = "+3,500.00",
                fromAccountBank = "Krungthai",
                fromAccountNo = "XXX-X-XX984-3",
                fromAccountName = "Malena Gautstafr"
            )
        )
        val result = transactionUseCase.execute(Unit).getOrNull()
        Assert.assertTrue(result.isNullOrEmpty().not() && result?.get(0)?.id == 3)
    }

    @Test(expected = Exception::class)
    fun `get transaction with failed repository`() = runTest {
        coEvery { accountRepository.getBookBankAll() } throws mockk<Exception>()
        val result = transactionUseCase.execute(Unit).getOrThrow()
        Assert.assertTrue(result.isEmpty())
    }
}