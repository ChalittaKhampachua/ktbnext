package com.ktb.ktbnext.data.model

interface Mapper<E, D> {
    fun map(input: E): D
}