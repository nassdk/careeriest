package com.nassdk.careeriest.common.extensions

fun <T> T?.ifNull(alternative: T): T = this ?: alternative