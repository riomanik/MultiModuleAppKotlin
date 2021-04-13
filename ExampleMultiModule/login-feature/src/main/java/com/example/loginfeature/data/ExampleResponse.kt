package com.example.loginfeature.data

import com.google.gson.annotations.SerializedName

data class ExampleResponse(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("completed") val completed: Boolean
)