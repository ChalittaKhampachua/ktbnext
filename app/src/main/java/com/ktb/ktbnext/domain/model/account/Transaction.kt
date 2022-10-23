package com.ktb.ktbnext.domain.model.account

data class Transaction(
    val name: String,
    val date: String,
    val amount: String,
    val fromAccountBank: String,
    val fromAccountNo: String,
    val fromAccountName: String
)
