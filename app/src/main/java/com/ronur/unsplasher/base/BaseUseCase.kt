package com.ronur.unsplasher.base

import com.ronur.unsplasher.utils.*
import com.ronur.unsplasher.utils.response.*
import kotlinx.coroutines.flow.flow

abstract class BaseUseCase<T,V> {
    internal abstract suspend fun getApiCall(): ApiResponse<T>
    internal abstract fun jsonToObject(jsonElement: T): V

    suspend operator fun invoke() = flow {
        getApiCall().apply {
            onSuccessSuspend {
                data?.let {
                    emit(DataState.success(jsonToObject(it)))
                }
            }.onErrorSuspend {
                emit(DataState.error<V>(message()))
            }.onExceptionSuspend {
                emit(DataState.error<V>(message()))
            }
        }
    }
}