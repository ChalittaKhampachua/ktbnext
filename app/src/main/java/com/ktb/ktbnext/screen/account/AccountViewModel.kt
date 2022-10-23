package com.ktb.ktbnext.screen.account

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktb.ktbnext.domain.model.account.BookBank
import com.ktb.ktbnext.domain.model.account.Transaction
import com.ktb.ktbnext.domain.usecase.account.BookBankUseCase
import com.ktb.ktbnext.domain.usecase.account.TransactionUseCase
import com.ktb.ktbnext.extension.addSources
import com.ktb.ktbnext.screen.account.model.AccountUI
import kotlinx.coroutines.launch

class AccountViewModel(
    private val bookBankUseCase: BookBankUseCase,
    private val transactionUseCase: TransactionUseCase,
): ViewModel() {

    val bookBankLiveData = MutableLiveData<List<BookBank>>()
    val transactionLiveData = MutableLiveData<List<Transaction>>()
    val accountUIDataSource = MediatorLiveData<AccountUI?>()

    init {
        accountUIDataSource.apply {
            fun setData() {
                value = AccountUI(
                    bookBankList = bookBankLiveData.value,
                    transactionList = transactionLiveData.value
                )
            }

            addSources(
                bookBankLiveData,
                transactionLiveData
            ) { setData() }

            setData()
        }
    }

    fun fetchAccountData() {
        fetchBookBank()
        fetchTransaction()
    }

    fun fetchBookBank() {
        viewModelScope.launch {
            bookBankUseCase.execute(Unit)
                .onSuccess {
                    bookBankLiveData.value = it
                }
                .onFailure {
                    //handle on call api fail
                }
        }
    }

    fun fetchTransaction() {
        viewModelScope.launch {
            transactionUseCase.execute(Unit)
                .onSuccess {
                    transactionLiveData.value = it
                }
                .onFailure {
                    //handle on call api fail
                }
        }
    }

    fun setTransactionExpanded(id: Int) {
        transactionLiveData.apply {
            value = value?.map {
                if(it.id == id) {
                    if (it.isExpanded == true) {
                        it.copy(isExpanded = false)
                    } else {
                        it.copy(isExpanded = true)
                    }
                } else {
                    it
                }
            }
        }
    }
}