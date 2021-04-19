package com.example.loginfeature.di

import com.example.core.di.CoreComponent
import com.example.loginfeature.module.LoginModule
import com.example.loginfeature.module.LoginViewModelModule
import com.example.loginfeature.presenter.LoginFragment
import com.example.loginfeature.scope.LoginFeatureScope
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [LoginViewModelModule::class, LoginModule::class]
)
@LoginFeatureScope
interface LoginComponent {

    @Component.Factory
    interface Factory {
        fun create(component: CoreComponent): LoginComponent
    }
    fun inject(loginFragment: LoginFragment)
}