package com.example.api.module

import com.example.api.feature.login.LoginApiModule
import dagger.Module

@Module(includes = [
    LoginApiModule::class
])
class ApiModule