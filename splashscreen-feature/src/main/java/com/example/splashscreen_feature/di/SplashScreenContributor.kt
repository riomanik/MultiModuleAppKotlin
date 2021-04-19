package com.example.splashscreen_feature.di

import com.example.splashscreen_feature.module.SplashScreenModule
import com.example.splashscreen_feature.presenter.SplashScreenFragment
import com.example.splashscreen_feature.scope.SplashScreenFeatureScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SplashScreenContributor {

    @SplashScreenFeatureScope
    @ContributesAndroidInjector(
        modules = [SplashScreenModule::class]
    )
    abstract fun splashScreenFragment(): SplashScreenFragment
}