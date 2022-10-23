package com.ktb.ktbnext.data.model.account

import com.google.gson.annotations.SerializedName

data class BookBankEntity(
    @SerializedName("data")
    val data: List<BookBankItem>? = null,
) {
    data class BookBankItem(
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("type")
        val type: String? = null,
        @SerializedName("number")
        val number: String? = null,
        @SerializedName("isMain")
        val isMain: Boolean? = null,
        @SerializedName("currentBalance")
        val currentBalance: String? = null,
        @SerializedName("availableBalance")
        val availableBalance: String? = null
    )
}
