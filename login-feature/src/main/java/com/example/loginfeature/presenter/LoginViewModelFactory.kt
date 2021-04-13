package com.example.loginfeature.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginfeature.domain.GetSharePrefIdUseCase
import com.example.loginfeature.domain.LoginDbUseCase
import com.example.loginfeature.domain.LoginUseCase
import javax.inject.Inject

class LoginViewModelFactory: ViewModelProvider.Factory {

    private val component by lazy {
        LoginActivity.instance.component
    }

    @Inject
    lateinit var loginUseCase: LoginUseCase

    @Inject
    lateinit var getSharePrefIdUseCase: GetSharePrefIdUseCase

    @Inject
    lateinit var loginDbUseCase: LoginDbUseCase

    init {
        component.inject(this)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.cast(
            LoginViewModel(
                loginUseCase,
                getSharePrefIdUseCase,
                loginDbUseCase
            )
        ) as T
    }

}