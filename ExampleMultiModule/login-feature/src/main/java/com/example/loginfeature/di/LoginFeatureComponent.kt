package com.example.loginfeature.di

import com.example.core.di.CoreComponent
import com.example.loginfeature.module.LoginModule
import com.example.loginfeature.presenter.LoginActivity
import com.example.loginfeature.presenter.LoginViewModelFactory
import com.example.loginfeature.scope.LoginFeatureScope
import dagger.Component

@LoginFeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [LoginModule::class]
)
interface LoginFeatureComponent {

    fun inject(activity: LoginActivity)

    fun inject(factory: LoginViewModelFactory)

}