package com.example.loginfeature.domain

import com.example.core.base.BaseUseCase
import com.example.loginfeature.data.ExampleResponse
import io.reactivex.Single
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
): BaseUseCase<ExampleResponse>() {

    override fun buildSingle(): Single<ExampleResponse> {
        return loginRepository.getUserInfo()
    }

}