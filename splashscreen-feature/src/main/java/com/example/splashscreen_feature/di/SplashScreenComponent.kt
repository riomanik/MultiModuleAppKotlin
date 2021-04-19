package com.example.splashscreen_feature.di

import com.example.core.di.CoreComponent
import com.example.splashscreen_feature.module.SplashScreenModule
import com.example.splashscreen_feature.presenter.SplashScreenFragment
import com.example.splashscreen_feature.scope.SplashScreenFeatureScope
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [SplashScreenModule::class]
)
@SplashScreenFeatureScope
interface SplashScreenComponent {

    @Component.Factory
    interface Factory {
        fun create(component: CoreComponent): SplashScreenComponent
    }

    fun inject(splashScreenFragment: SplashScreenFragment)
}