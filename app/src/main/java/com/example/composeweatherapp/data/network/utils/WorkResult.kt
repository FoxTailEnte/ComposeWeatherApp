package com.example.composeweatherapp.data.network.utils

sealed class WorkResult<out T> {
    object EmptyResult : WorkResult<Nothing>()

    data class SuccessResult<T>(
        val data: T
    ) : WorkResult<T>()

    data class Fail(
        val exception: Throwable? = null
    ) : WorkResult<Nothing>()

    data class ErrorResult(
        val exception: Exception,
        val message: String?
    ) : WorkResult<Nothing>()
}