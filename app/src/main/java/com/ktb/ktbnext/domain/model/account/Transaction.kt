package com.ktb.ktbnext.domain.model.account

data class Transaction(
    val id: Int,
    val name: String,
    val date: String,
    val amount: String,
    val fromAccountBank: String,
    val fromAccountNo: String,
    val fromAccountName: String,
    val isExpanded: Boolean? = false
)
