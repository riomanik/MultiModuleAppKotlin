package com.example.api.feature.login.usecase

import com.example.api.feature.login.LoginApiRepository
import com.example.core.base.BaseUseCase
import com.example.entity.login.domain.Login
import io.reactivex.Single
import javax.inject.Inject

class LoginDbUseCase @Inject constructor(
    private val loginApiRepository: LoginApiRepository
): BaseUseCase<Login>() {

    fun saveDataToDb(login: Login) {
        loginApiRepository.saveDataToDb(login)
    }

    override fun buildSingle(): Single<Login> {
        return loginApiRepository.getDataFromDb()
    }

}