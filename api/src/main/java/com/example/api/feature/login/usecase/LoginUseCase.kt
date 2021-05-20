package com.example.api.feature.login.usecase

import com.example.api.feature.login.LoginApiRepository
import com.example.core.base.BaseUseCase
import com.example.entity.login.payload.ExampleResponse
import io.reactivex.Single
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginApiRepository: LoginApiRepository
): BaseUseCase<ExampleResponse>() {

    override fun buildSingle(): Single<ExampleResponse> {
        return loginApiRepository.getUserInfo()
    }

}