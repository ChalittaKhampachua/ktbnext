package com.ktb.ktbnext.screen.account

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ktb.ktbnext.TestCoroutineRule
import com.ktb.ktbnext.domain.model.account.BookBank
import com.ktb.ktbnext.domain.model.account.Transaction
import com.ktb.ktbnext.domain.usecase.account.BookBankUseCase
import com.ktb.ktbnext.domain.usecase.account.TransactionUseCase
import com.ktb.ktbnext.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AccountViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @MockK
    private lateinit var viewModel: AccountViewModel

    private val bookBankUseCase: BookBankUseCase = mockk()
    private val transactionUseCase: TransactionUseCase = mockk()

    @Before
    fun setUp() {
        viewModel = AccountViewModel(bookBankUseCase, transactionUseCase)
    }

    @Test
    fun `fetch book bank success`() = testCoroutineRule.runBlockingTest {
        val expectBookBank: List<BookBank> = listOf(
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
        coEvery { bookBankUseCase.execute(Unit).getOrNull() } returns expectBookBank

        viewModel.fetchBookBank()

        Assert.assertEquals(expectBookBank, viewModel.bookBankLiveData.getOrAwaitValue())
    }

    @Test
    fun `fetch transaction success`() = testCoroutineRule.runBlockingTest {
        val expectTransaction: List<Transaction> = listOf(
            Transaction(
                id = 1,
                name = "Transfer out",
                date = "20 Nov 2019 - 12:00",
                amount = "-1,500.00",
                fromAccountBank = "Krungthai",
                fromAccountNo = "XXX-X-XX545-1",
                fromAccountName = "Nils Kizzie"
            )
        )
        coEvery { transactionUseCase.execute(Unit).getOrNull() } returns expectTransaction

        viewModel.fetchTransaction()

        Assert.assertEquals(expectTransaction, viewModel.transactionLiveData.getOrAwaitValue())
    }

    @Test
    fun `set transaction expanded success`() {
        viewModel.transactionLiveData.value  = listOf(
            Transaction(
                id = 1,
                name = "Transfer out",
                date = "20 Nov 2019 - 12:00",
                amount = "-1,500.00",
                fromAccountBank = "Krungthai",
                fromAccountNo = "XXX-X-XX545-1",
                fromAccountName = "Nils Kizzie",
                isExpanded = false
            )
        )

        viewModel.setTransactionExpanded(1)

        viewModel.transactionLiveData.getOrAwaitValue().get(0).isExpanded?.let {
            Assert.assertTrue(it)
        }
    }
}