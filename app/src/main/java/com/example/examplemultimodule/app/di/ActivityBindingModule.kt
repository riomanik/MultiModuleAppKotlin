package com.example.examplemultimodule.app.di

import com.example.examplemultimodule.app.MainActivity
import com.example.loginfeature.di.LoginContributor
import com.example.splashscreen_feature.di.SplashScreenContributor
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
        (
        modules = [
            SplashScreenContributor::class,
            LoginContributor::class]
    )
    abstract fun mainActivity(): MainActivity
}