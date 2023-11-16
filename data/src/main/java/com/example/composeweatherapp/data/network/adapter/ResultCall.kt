package com.example.composeweatherapp.data.network.adapter

import com.example.composeweatherapp.data.network.utils.WorkResult
import com.google.gson.Gson
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.net.HttpURLConnection

internal class ResultCall<T>(proxy: Call<T>) : CallDelegate<T, WorkResult<T>>(proxy) {

    override fun enqueueImpl(callback: Callback<WorkResult<T>>) {
        proxy.enqueue(ResultCallback(this, callback))
    }

    override fun cloneImpl(): ResultCall<T> {
        return ResultCall(proxy.clone())
    }

    private class ResultCallback<T>(
        private val proxy: ResultCall<T>,
        private val callback: Callback<WorkResult<T>>
    ) : Callback<T> {

        override fun onResponse(call: Call<T>, response: Response<T>) {
            val result = when {
                response.isSuccessful && response.code() == HttpURLConnection.HTTP_NO_CONTENT -> WorkResult.EmptyResult
                response.isSuccessful -> WorkResult.SuccessResult(response.body() as T)
                else -> {
                    val httpException = NetworkHttpException(response.code(), response.message())
                    val error = try {
                        Gson().fromJson(
                            response.errorBody()!!.charStream(),
                            ErrorDto::class.java
                        )
                    } catch (e: Exception) {
                        ErrorDto(false, null, null)
                    }

                    WorkResult.ErrorResult(httpException, error.message)
                }
            }

            callback.onResponse(proxy, Response.success(result))
        }

        override fun onFailure(call: Call<T>, error: Throwable) {
            val result = when (error) {
                is IOException -> WorkResult.Fail(NetworkException(error))
                else -> WorkResult.Fail(UndefinedException(error))
            }

            callback.onResponse(proxy, Response.success(result))
        }
    }

    override fun timeout(): Timeout {
        return proxy.timeout()
    }
}