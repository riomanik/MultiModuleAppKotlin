package com.example.loginfeature.di.module.module

import com.example.api.module.ApiModule
import dagger.Module

@Module(
    includes = [
        LoginViewModelModule::class,
        LoginFragmentBuilderModule::class,
        ApiModule::class
    ]
)
class LoginModule