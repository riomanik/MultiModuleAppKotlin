package com.example.api.feature.login.usecase

import com.example.api.feature.login.LoginRepository
import com.example.core.base.BaseUseCase
import com.example.entity.login.payload.ExampleResponse
import io.reactivex.Single
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
): BaseUseCase<ExampleResponse>() {

    override fun buildSingle(): Single<ExampleResponse> {
        return loginRepository.getUserInfo()
    }

}