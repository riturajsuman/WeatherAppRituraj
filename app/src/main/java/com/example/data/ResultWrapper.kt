package com.example.data

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(
        val exception: Throwable,
        val message: String? = exception.localizedMessage
    ) : ResultWrapper<Nothing>()
    object NetWorkError : ResultWrapper<Nothing>()
}