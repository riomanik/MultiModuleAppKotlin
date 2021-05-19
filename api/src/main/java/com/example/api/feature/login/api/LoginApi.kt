package com.example.api.feature.login.api

import com.example.entity.login.payload.ExampleResponse
import io.reactivex.Single
import retrofit2.http.GET

interface LoginApi {

    @GET("todos/1")
    fun getUserInfo(): Single<ExampleResponse>
}