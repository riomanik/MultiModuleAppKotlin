package com.example.splashscreen_feature.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginfeature.domain.LoginDbUseCase
import javax.inject.Inject

class SplashScreenViewModelFactory: ViewModelProvider.Factory {

    private val component by lazy {
        SplashScreenActivity.instance.component
    }

    init {
        component.inject(this)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.cast(
            SplashScreenViewModel(
            )
        ) as T
    }

}