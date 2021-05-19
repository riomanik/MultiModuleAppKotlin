package com.example.core.common


open class MyCustomHttpException(val response: ErrorResponse) : Exception() {
    companion object {
        const val CODE_BAD_REQUEST = 400
        const val CODE_UNAUTHORIZED = 401
        const val CODE_FORBIDDEN = 403
        const val CODE_NOT_FOUND = 404
        const val CODE_UNPROCESSABLE = 422
        const val CODE_SERVER_ERROR = 500

    }
}

class MyCustomBadRequestException(response: ErrorResponse) : MyCustomHttpException(response)
class MyCustomForbiddenException(response: ErrorResponse) : MyCustomHttpException(response)
class MyCustomNotFoundException(response: ErrorResponse) : MyCustomHttpException(response)
class MyCustomNetWorkException(response: ErrorResponse) : MyCustomHttpException(response)
class MyCustomTimeoutException(response: ErrorResponse) : MyCustomHttpException(response)
class MyCustomServerException(response: ErrorResponse) : MyCustomHttpException(response)
class MyCustomUnauthorizedException(response: ErrorResponse) : MyCustomHttpException(response)
class MyCustomUnprocessableException(response: ErrorResponse) : MyCustomHttpException(response)
