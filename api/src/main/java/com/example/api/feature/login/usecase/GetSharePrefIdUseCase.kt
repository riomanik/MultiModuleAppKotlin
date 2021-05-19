package com.example.api.feature.login.usecase

import com.example.api.feature.login.LoginRepository
import com.example.core.base.BaseUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetSharePrefIdUseCase @Inject constructor(
    private val loginRepository: LoginRepository
): BaseUseCase<String>() {

    override fun buildSingle(): Single<String> {
        return loginRepository.getUserIdPref()
    }

}