package com.example.loginfeature.data

import io.reactivex.Single
import retrofit2.http.GET

interface LoginApi {

    @GET("todos/1")
    fun getUserInfo(): Single<ExampleResponse>
}