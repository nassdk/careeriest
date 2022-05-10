package com.nassdk.careeriest.network.model

sealed class ErrorEntity : Exception() {
    object Unknown : ErrorEntity()
    object ServerError : ErrorEntity()
    object Network : ErrorEntity()
    object Unauthorized : ErrorEntity()
    data class ReadableError(val errorMessage: String, val code: Int) : ErrorEntity()
}