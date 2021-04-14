package com.example.splashscreen_feature.di

import com.example.core.di.CoreComponent
import com.example.loginfeature.di.LoginFeatureComponent
import com.example.splashscreen_feature.module.SplashScreenModule
import com.example.splashscreen_feature.presenter.SplashScreenActivity
import com.example.splashscreen_feature.presenter.SplashScreenViewModelFactory
import com.example.splashscreen_feature.scope.SplashScreenFeatureScope
import dagger.Component

@SplashScreenFeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [SplashScreenModule::class]
)
interface SplashScreenFeatureComponent {

    fun inject(activity: SplashScreenActivity)

    fun inject(factory: SplashScreenViewModelFactory)

}