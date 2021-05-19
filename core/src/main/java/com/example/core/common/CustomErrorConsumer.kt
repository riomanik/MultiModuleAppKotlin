package com.example.core.common

import io.reactivex.functions.Consumer
import java.io.IOException
import java.net.*


abstract class CustomErrorConsumer : Consumer<Throwable> {

    override fun accept(throwable: Throwable) {
        if (throwable is MyCustomHttpException) {
            accept(throwable)
        } else {
            val errorBody = ErrorResponse()
            val errorResponseMessage = ErrorResponse.ErrorResponseMessage()
            errorResponseMessage.en = throwable.message
            errorResponseMessage.id = throwable.message
            errorBody.message = errorResponseMessage
            accept(createMyCustomException(throwable, errorBody))
        }
    }

    private fun createMyCustomException(throwable: Throwable, errorBody: ErrorResponse): MyCustomHttpException {
        return when(throwable) {
            is UnknownHostException, is ConnectException, is UnknownServiceException, is SocketException, is IOException -> MyCustomNetWorkException(errorBody)
            is SocketTimeoutException -> MyCustomTimeoutException(errorBody)
            else -> MyCustomHttpException(errorBody)
        }
    }

    abstract fun accept(it: MyCustomHttpException)
}
