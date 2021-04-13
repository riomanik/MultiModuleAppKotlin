package com.example.loginfeature.domain

import com.example.loginfeature.data.ExampleResponse
import io.reactivex.Completable
import io.reactivex.Single

interface LoginRepository {

    fun getUserInfo(): Single<ExampleResponse>

    fun getUserIdPref(): Single<String>

    fun saveDataToDb(login: Login): Completable

    fun getDataFromDb(): Single<List<Login>>

}