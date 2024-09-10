package com.shivansh.androidstarter.utils


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

val <T : Any?> Result<T>.exception
    get() = exceptionOrNull()?.let { Exception(it) } ?: Exception()


inline fun <T> result(block: () -> T): Result<T> {
    return try {
        Result.success(block())
    } catch (e: Exception) {
        Result.failure(e)
    }
}

fun <V : Any?> Result<V>.requireData() = getOrNull() ?: throw exception

inline fun <V : Any?, U : Any?> Result<V>.mapResult(crossinline transform: (V) -> U): Result<U> =
    try {
        Result.success(transform(requireData()))
    } catch (ex: Exception) {
        Result.failure(ex)
    }

suspend inline fun <V : Any?, U : Any?> Result<V>.mapFailed(
    vararg exceptions: Exception,
    crossinline transform: suspend (Exception) -> V
): Result<V> =
    if (isFailure && exceptionOrNull() in exceptions) {
        Result.success(transform(exception))
    } else {
        this
    }

suspend inline fun <V : Any?> Flow<Result<V>>.mapFailed(
    vararg exceptions: Exception,
    crossinline transform: suspend (Exception) -> V
): Flow<Result<V>> = map {
    if (it.isFailure && it.exception in exceptions) {
        Result.success(transform(it.exception))
    } else {
        it
    }
}

inline fun <V : Any?, U : Any?> Result<V>.mapSuccess(
    crossinline transform: (V) -> U
): Result<U> =
    if (isSuccess) Result.success(transform(requireData())) else Result.failure(exception)


inline fun <V : Any?, U : Any?> Flow<Result<V>>.mapSuccess(
    crossinline transform: (V) -> U
): Flow<Result<U>> = map { result ->
    if (result.isSuccess) Result.success(transform(result.requireData()))
    else Result.failure(result.exception)
}

suspend inline fun <V : Any?> Flow<Result<V>>.mapFailed(
    crossinline transform: suspend (Exception?) -> V
): Flow<Result<V>> = map { result ->
    if (result.isFailure) Result.success(transform(result.exception)) else Result.success(result.requireData())
}

inline fun <V : Any?, U : Any?> Flow<Result<V>>.mapResult(crossinline transform: (V) -> U): Flow<Result<U>> =
    map {
        it.mapResult(transform)
    }

fun <V : Any?> Flow<Result<V>>.getSuccessFlow(): Flow<V> = mapNotNull {
    it.getOrNull()
}

fun <T: Any?> List<Result<T>>.flattenSuccess(): Result<List<T>> = result {
    mapNotNull { result ->
        result.getOrNull()
    }
}