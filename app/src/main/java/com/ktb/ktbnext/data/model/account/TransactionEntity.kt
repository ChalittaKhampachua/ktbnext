package com.ktb.ktbnext.data.model.account

import com.google.gson.annotations.SerializedName

data class TransactionEntity(
    @SerializedName("data")
    val data: List<TransactionItem>? = null,
) {
    data class  TransactionItem(
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("date")
        val date: String? = null,
        @SerializedName("amount")
        val amount: String? = null,
        @SerializedName("fromAccountBank")
        val fromAccountBank: String? = null,
        @SerializedName("fromAccountNo")
        val fromAccountNo: String? = null,
        @SerializedName("fromAccountName")
        val fromAccountName: String? = null
    )
}
