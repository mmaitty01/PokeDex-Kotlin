package org.swu.pokedex0528.extension

import org.swu.pokedex0528.base.service.BaseAppException
import org.swu.pokedex0528.base.service.UseCaseResult

suspend fun <T> handleUseCaseException(apiCall: suspend () -> T): UseCaseResult<T> {
    return try {
        UseCaseResult.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
        UseCaseResult.Error(BaseAppException(throwable))
    }
}
