package com.ktb.ktbnext.domain.model.account

data class BookBank(
    val name: String,
    val type: String,
    val number: String,
    val isMain: Boolean,
    val currentBalance: String,
    val availableBalance: String
)
