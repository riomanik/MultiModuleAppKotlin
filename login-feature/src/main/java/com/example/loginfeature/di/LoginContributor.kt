package com.example.loginfeature.di

import com.example.loginfeature.module.LoginAbstractModule
import com.example.loginfeature.module.LoginModule
import com.example.loginfeature.presenter.LoginFragment
import com.example.loginfeature.scope.LoginFeatureScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginContributor {

    @LoginFeatureScope
    @ContributesAndroidInjector(
        modules = [LoginModule::class, LoginAbstractModule::class]
    )
    abstract fun loginFragment(): LoginFragment
}