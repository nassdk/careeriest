package com.nassdk.careeriest.network.wrapper

import com.nassdk.careeriest.network.model.ErrorEntity

interface ErrorWrapper {
    fun getError(throwable: Throwable): ErrorEntity
}