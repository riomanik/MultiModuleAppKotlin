package com.example.splashscreen_feature.di.module

import dagger.Module

@Module(includes = [SplashViewModelModule::class, SplashFragmentBuilderModule::class])
abstract class SplashScreenModule