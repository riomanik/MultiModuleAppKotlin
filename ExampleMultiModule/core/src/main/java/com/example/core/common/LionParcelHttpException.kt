package com.example.core.common


open class LionParcelHttpException(val response: ErrorResponse) : Exception() {
    companion object {
        const val CODE_BAD_REQUEST = 400
        const val CODE_UNAUTHORIZED = 401
        const val CODE_FORBIDDEN = 403
        const val CODE_NOT_FOUND = 404
        const val CODE_UNPROCESSABLE = 422
        const val CODE_SERVER_ERROR = 500

    }
}

class LionParcelBadRequestException(response: ErrorResponse) : LionParcelHttpException(response)
class LionParcelForbiddenException(response: ErrorResponse) : LionParcelHttpException(response)
class LionParcelNotFoundException(response: ErrorResponse) : LionParcelHttpException(response)
class LionParcelNetWorkException(response: ErrorResponse) : LionParcelHttpException(response)
class LionParcelTimeoutException(response: ErrorResponse) : LionParcelHttpException(response)
class LionParcelServerException(response: ErrorResponse) : LionParcelHttpException(response)
class LionParcelUnauthorizedException(response: ErrorResponse) : LionParcelHttpException(response)
class LionParcelUnprocessableException(response: ErrorResponse) : LionParcelHttpException(response)
