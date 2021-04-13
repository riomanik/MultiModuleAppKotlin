package com.example.loginfeature.domain

import com.example.core.base.BaseUseCase
import com.example.loginfeature.data.ExampleResponse
import io.reactivex.Single
import javax.inject.Inject

class GetSharePrefIdUseCase @Inject constructor(
    private val loginRepository: LoginRepository
): BaseUseCase<String>() {

    override fun buildSingle(): Single<String> {
        return loginRepository.getUserIdPref()
    }

}