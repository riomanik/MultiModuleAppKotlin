package com.example.api.module

import com.example.api.feature.login.LoginModule
import dagger.Module

@Module(includes = [
    LoginModule::class
])
class ApiModule