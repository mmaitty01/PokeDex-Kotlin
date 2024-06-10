package org.swu.pokedex0528.base.service

import retrofit2.HttpException

open class BaseAppException(private val exception: Throwable?) : Exception() {
    constructor(message: String) : this(Throwable(message))
    fun getErrorCode(): Int? =
        if (exception is HttpException) exception.code() else null
}