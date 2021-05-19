package com.example.loginfeature.di.module.module

import com.example.loginfeature.view.screen.LoginFragment
import com.example.loginfeature.di.scope.LoginFeatureScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginFragmentBuilderModule {

    @LoginFeatureScope
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): LoginFragment

}