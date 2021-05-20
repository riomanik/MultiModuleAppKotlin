package com.example.api.feature.login.usecase

import com.example.api.feature.login.LoginApiRepository
import com.example.core.base.BaseUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetSharePrefIdUseCase @Inject constructor(
    private val loginApiRepository: LoginApiRepository
): BaseUseCase<String>() {

    override fun buildSingle(): Single<String> {
        return loginApiRepository.getUserIdPref()
    }

}