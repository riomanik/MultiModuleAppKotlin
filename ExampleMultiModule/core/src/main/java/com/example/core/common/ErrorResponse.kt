package com.example.core.common

import com.google.gson.annotations.SerializedName

class ErrorResponse() {

    constructor(message: ErrorResponseMessage) : this() {
        this.message = message
    }

    @SerializedName("error_id")
    var errorId: Int = -1

    @SerializedName("message")
    lateinit var message: ErrorResponseMessage

    class ErrorResponseMessage {
        @SerializedName("en") var en: String? = null
        @SerializedName("id") var id: String? = null
    }
}
