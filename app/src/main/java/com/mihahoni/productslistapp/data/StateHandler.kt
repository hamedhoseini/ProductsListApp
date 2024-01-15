package com.mihahoni.productslistapp.data

sealed class StateHandler {
    data class Success<T>(var data: T?) : StateHandler()
    data class Failure(var message: String?) : StateHandler()
    data object Loading : StateHandler()
}