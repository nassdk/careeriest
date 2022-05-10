package com.nassdk.careeriest.network.di

import com.nassdk.careeriest.network.BuildConfig
import com.nassdk.careeriest.network.NetworkApi
import com.nassdk.careeriest.network.NetworkApiImpl
import com.nassdk.careeriest.network.wrapper.ErrorWrapper
import com.nassdk.careeriest.network.wrapper.ErrorWrapperImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
internal abstract class NetworkModule {

    @Binds
    @NetworkScope
    abstract fun bindModuleApi(impl: NetworkApiImpl): NetworkApi

    @Binds
    @Reusable
    abstract fun bindErrorWrapper(impl: ErrorWrapperImpl): ErrorWrapper

    companion object {

        @Provides
        @Reusable
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

        @Provides
        @Reusable
        fun provideOkHttp3(
            loggingInterceptor: HttpLoggingInterceptor,
        ): OkHttpClient = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(loggingInterceptor)
            }
        }.build()


        @Provides
        @Reusable
        fun provideJson(): Json {
            return Json(Json.Default) {
                isLenient = true
                ignoreUnknownKeys = true
            }
        }
    }
}