package com.example.loginfeature.module

import androidx.lifecycle.ViewModel
import com.example.core.di.keys.ViewModelKey
import com.example.loginfeature.presenter.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginAbstractModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun detailViewModel(loginViewModel: LoginViewModel): ViewModel

}