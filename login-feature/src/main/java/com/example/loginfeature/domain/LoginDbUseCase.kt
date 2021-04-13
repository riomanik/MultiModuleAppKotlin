package com.example.loginfeature.domain

import com.example.core.base.BaseUseCase
import io.reactivex.Single
import javax.inject.Inject
import com.example.core_entity.login.Login

class LoginDbUseCase @Inject constructor(
    private val loginRepository: LoginRepository
): BaseUseCase<Login>() {

    fun saveDataToDb(login: Login) {
        loginRepository.saveDataToDb(login)
    }

    override fun buildSingle(): Single<Login> {
        return loginRepository.getDataFromDb()
    }

}