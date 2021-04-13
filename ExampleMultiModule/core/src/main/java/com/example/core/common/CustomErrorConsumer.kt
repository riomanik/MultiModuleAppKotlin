package com.example.core.common

import io.reactivex.functions.Consumer
import java.io.IOException
import java.net.*


abstract class CustomErrorConsumer : Consumer<Throwable> {

    override fun accept(throwable: Throwable) {
        if (throwable is LionParcelHttpException) {
            accept(throwable)
        } else {
            val errorBody = ErrorResponse()
            val errorResponseMessage = ErrorResponse.ErrorResponseMessage()
            errorResponseMessage.en = throwable.message
            errorResponseMessage.id = throwable.message
            errorBody.message = errorResponseMessage
            accept(createLionParcelException(throwable, errorBody))
        }
    }

    private fun createLionParcelException(throwable: Throwable, errorBody: ErrorResponse): LionParcelHttpException {
        return when(throwable) {
            is UnknownHostException, is ConnectException, is UnknownServiceException, is SocketException, is IOException -> LionParcelNetWorkException(errorBody)
            is SocketTimeoutException -> LionParcelTimeoutException(errorBody)
            else -> LionParcelHttpException(errorBody)
        }
    }

    abstract fun accept(it: LionParcelHttpException)
}
