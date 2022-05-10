package com.nassdk.careeriest.network.adapter

import com.nassdk.careeriest.network.di.NetworkScope
import com.nassdk.careeriest.network.model.NetworkResult
import com.nassdk.careeriest.network.wrapper.ErrorWrapper
import dagger.Lazy
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import javax.inject.Inject

@NetworkScope
internal class STCallAdapterFactory @Inject constructor(
    private val errorWrapper: Lazy<ErrorWrapper>
) : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        if (getRawType(returnType) != Call::class.java) {
            return null
        }

        val callType = getParameterUpperBound(0, returnType as ParameterizedType)

        if (getRawType(callType) != NetworkResult::class.java) {
            return null
        }

        val resultType = getParameterUpperBound(0, callType as ParameterizedType)

        return NetworkResultCallAdapter(resultType = resultType, errorWrapper = errorWrapper.get())
    }
}