package com.tf.potterpedie.data.core

import com.tf.potterpedie.domain.core.DataState
import retrofit2.Response
import timber.log.Timber

abstract class BaseNetworkDataSource {
    protected open suspend fun <T> getResult(call: suspend () -> Response<T>): DataState<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let { return DataState.Success(body) }
            }
            return error("${response.code()} ${response.message()}")

        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): DataState<T> {
        Timber.d(message)
        return DataState.Error(message)
    }
}