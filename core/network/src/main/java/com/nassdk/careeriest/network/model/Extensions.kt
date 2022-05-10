package com.nassdk.careeriest.network.model

import com.nassdk.careeriest.network.wrapper.ErrorWrapper
import retrofit2.Response

internal fun <T : Any> handleApi(
    errorWrapper: ErrorWrapper,
    execute: () -> Response<T>
): NetworkResult<T> = try {

    val response = execute()

    val body = response.body()

    if (response.isSuccessful && body != null) {
        RequestSuccess(body)
    } else {
        RequestError(
            error = ErrorEntity.ReadableError(
                code = response.code(),
                errorMessage = response.message()
            )
        )
    }
} catch (exception: Throwable) {
    when (val error = errorWrapper.getError(throwable = exception)) {
        is ErrorEntity.ReadableError -> RequestError(error = error)
        is ErrorEntity.Unauthorized  -> throw error
        else                         -> {
            RequestError<T>(error)
            throw error
        }
    }
}

suspend fun <T : Any> NetworkResult<T>.handle(
    onSuccess: suspend (T) -> Unit,
    onError: suspend (error: ErrorEntity) -> Unit
): NetworkResult<T> = apply {
    when (this) {
        is RequestSuccess<T> -> onSuccess.invoke(data)
        is RequestError<T>   -> onError.invoke(error)
    }
}