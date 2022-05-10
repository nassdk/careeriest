package com.nassdk.careeriest.network.adapter

import com.nassdk.careeriest.network.model.NetworkResult
import com.nassdk.careeriest.network.model.handleApi
import com.nassdk.careeriest.network.wrapper.ErrorWrapper
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class StResultApiCall<T : Any>(
    private val errorWrapper: ErrorWrapper,
    private val proxy: Call<T>
) : Call<NetworkResult<T>> {

    override fun enqueue(callback: Callback<NetworkResult<T>>) {
        proxy.enqueue(
            object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {

                    val networkResult = handleApi(
                        errorWrapper = errorWrapper,
                        execute = { response }
                    )

                    callback.onResponse(this@StResultApiCall, Response.success(networkResult))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    callback.onResponse(this@StResultApiCall, Response.success(null))
                }
            }
        )
    }

    override fun execute(): Response<NetworkResult<T>> = throw NotImplementedError()
    override fun request(): Request = proxy.request()
    override fun timeout(): Timeout = proxy.timeout()
    override fun isExecuted(): Boolean = proxy.isExecuted
    override fun isCanceled(): Boolean = proxy.isCanceled
    override fun cancel() = proxy.cancel()

    override fun clone(): Call<NetworkResult<T>> {
        return StResultApiCall(proxy = proxy.clone(), errorWrapper = errorWrapper)
    }
}