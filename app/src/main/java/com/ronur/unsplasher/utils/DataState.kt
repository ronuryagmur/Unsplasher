package com.ronur.unsplasher.utils

sealed class DataState<T> {
    data class Success<T>(val data: T) : DataState<T>()
    data class Error<T>(val message: String) : DataState<T>()

    companion object {
        fun <T> success(data: T) = Success<T>(data)
        fun <T> error(message: String) = Error<T>(message)
    }
}

@SuspensionFunction
suspend fun <T> DataState<T>.onSuccessState(
    onResult: suspend DataState.Success<T>.() -> Unit
): DataState<T> {
    if (this is DataState.Success) {
        onResult(this)
    }
    return this
}

@SuspensionFunction
suspend fun <T> DataState<T>.onErrorState(
    onResult: suspend DataState.Error<T>.() -> Unit
): DataState<T> {
    if (this is DataState.Error) {
        onResult(this)
    }
    return this
}

@DslMarker
internal annotation class SuspensionFunction