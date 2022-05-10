package com.nassdk.careeriest.network.adapter

import com.nassdk.careeriest.network.wrapper.ErrorWrapper
import com.nassdk.careeriest.network.model.NetworkResult
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

internal class NetworkResultCallAdapter(
    private val resultType: Type,
    private val errorWrapper: ErrorWrapper
) : CallAdapter<Type, Call<NetworkResult<Type>>> {

    override fun responseType(): Type = resultType

    override fun adapt(call: Call<Type>): Call<NetworkResult<Type>> {
        return StResultApiCall(proxy = call, errorWrapper = errorWrapper)
    }
}