package com.example.examplemultimodule.app.di.module

import com.example.loginfeature.di.module.module.LoginModule
import com.example.splashscreen_feature.di.module.SplashScreenModule
import dagger.Module

@Module(
    includes = [
        SplashScreenModule::class,
        LoginModule::class
    ]
)
class FeatureBuilderModule