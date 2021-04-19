package com.example.loginfeature.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.di.ViewModelFactory
import com.example.core.di.keys.ViewModelKey
import com.example.loginfeature.presenter.LoginViewModel
import com.example.loginfeature.scope.LoginFeatureScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface LoginViewModelModule {

    @Binds
    @LoginFeatureScope
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindCompetitionsViewModel(viewModel: LoginViewModel): ViewModel

}