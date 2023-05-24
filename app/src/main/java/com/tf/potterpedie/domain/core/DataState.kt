package com.tf.potterpedie.domain.core

sealed class DataState<out T>{
    data class Success<out T>(val data: T): DataState<T>()
    class Loading<out T>: DataState<T>()
    data class Error<out T>(val message: String): DataState<T>()
}
