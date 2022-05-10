package com.nassdk.careeriest.network.di

import com.nassdk.careeriest.network.NetworkApi
import com.nassdk.careeriest.network.NetworkApiImpl
import dagger.BindsInstance
import dagger.Component
import okhttp3.Interceptor

@NetworkScope
@Component(modules = [NetworkModule::class])
internal interface NetworkComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance interceptor: Interceptor): NetworkComponent
    }

    fun inject(apiImpl: NetworkApiImpl)

    fun moduleApi(): NetworkApi
}