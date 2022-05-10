package com.nassdk.careeriest.network.model

sealed interface NetworkResult<T : Any>

class RequestSuccess<T : Any>(val data: T) : NetworkResult<T>
class RequestError<T : Any>(val error: ErrorEntity) : NetworkResult<T>