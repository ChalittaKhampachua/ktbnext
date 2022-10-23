package com.ktb.ktbnext.data.model

import com.ktb.ktbnext.data.model.account.BookBankItem

interface Mapper<E, D> {
    fun map(input: BookBankItem): D
}