package com.example.api.feature.login

import com.example.entity.login.domain.Login
import com.example.entity.login.payload.ExampleResponse
import io.reactivex.Completable
import io.reactivex.Single

interface LoginRepository {

    fun getUserInfo(): Single<ExampleResponse>

    fun getUserIdPref(): Single<String>

    fun saveDataToDb(login: Login): Completable

    fun getDataFromDb(): Single<Login>

}