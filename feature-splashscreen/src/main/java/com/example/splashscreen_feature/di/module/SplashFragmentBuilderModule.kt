package com.example.splashscreen_feature.di.module

import com.example.splashscreen_feature.di.scope.SplashScreenFeatureScope
import com.example.splashscreen_feature.view.screen.SplashScreenFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SplashFragmentBuilderModule {

    @SplashScreenFeatureScope
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashScreenFragment

}