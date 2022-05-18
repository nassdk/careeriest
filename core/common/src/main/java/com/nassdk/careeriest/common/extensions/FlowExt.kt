package com.nassdk.careeriest.common.extensions

import kotlinx.coroutines.flow.Flow

suspend inline fun <T> Flow<T>.collect(crossinline action: suspend (value: T) -> Unit): Unit =
    collect { value -> action(value) }