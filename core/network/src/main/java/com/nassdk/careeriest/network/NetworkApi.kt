package com.nassdk.careeriest.network

interface NetworkApi {

    /**
     * Предоставление апи класса для остальных фичей
     */
    fun <T> provideApiClass(interfaceClass: Class<T>): T


    /**
     * Предоставление апи класса для остальных фичей с кастомным base url-ом
     */
    fun <T> provideApiClass(interfaceClass: Class<T>, baseUrl: String): T

}