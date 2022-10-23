package com.ktb.ktbnext.screen.account

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktb.ktbnext.screen.account.model.AccountUI
import kotlinx.coroutines.launch

class AccountViewModel: ViewModel() {

    private val bookBankLiveData = MutableLiveData<List<String>>()
    val accountUIDataSource = MediatorLiveData<AccountUI>()

    init {
        accountUIDataSource.apply {
            fun setData() {
                value = AccountUI(
                    bookBankList = bookBankLiveData.value
                )
            }

            addSource(
                bookBankLiveData,
            ) { setData() }

            setData()
        }
    }

    fun fetchAccountData() {
        viewModelScope.launch {
            bookBankLiveData.value = emptyList()
        }
    }
}