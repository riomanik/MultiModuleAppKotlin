package com.example.loginfeature.di.module.module

import androidx.lifecycle.ViewModel
import com.example.core.viewmodel.qualifier.ViewModelKey
import com.example.loginfeature.view.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class  LoginViewModelModule {

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

}