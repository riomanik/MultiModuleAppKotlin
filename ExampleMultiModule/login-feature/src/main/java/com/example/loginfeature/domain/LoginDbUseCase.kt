package com.example.loginfeature.domain

import com.example.core.base.BaseUseCase
import io.reactivex.Single
import javax.inject.Inject

class LoginDbUseCase @Inject constructor(
    private val loginRepository: LoginRepository
): BaseUseCase<List<Login>>() {

    fun saveDataToDb(login: Login) {
        loginRepository.saveDataToDb(login)
    }

    override fun buildSingle(): Single<List<Login>> {
        return loginRepository.getDataFromDb()
    }

}