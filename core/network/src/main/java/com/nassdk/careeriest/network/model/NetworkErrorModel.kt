package com.nassdk.careeriest.network.model

import kotlinx.serialization.SerialName

data class NetworkErrorModel(
    @SerialName(value = "code") val code: Int,
    @SerialName(value = "message") val message: String
)