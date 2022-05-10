package com.nassdk.careeriest.network

import com.nassdk.careeriest.network.di.NetworkComponent

object NetworkWrapper {

    private var component: NetworkComponent? = null

    fun getApi(): NetworkApi = getComponent().moduleApi()

    internal fun getComponent(): NetworkComponent = requireNotNull(component)
}