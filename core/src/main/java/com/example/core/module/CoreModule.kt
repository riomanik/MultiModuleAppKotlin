package com.example.core.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, SharedPrefModule::class, DatabaseModule::class])
class CoreModule(
    private val app: Application,
    private val apiUrl: String
) {

    @Singleton
    @Provides
    fun provideContext(): Context = app

    @Singleton
    @Provides
    fun provideApplication(): Application = app

    @Singleton
    @Provides
    @Named("BASE_API_URL")
    fun provideBaseApiUrl(): String = apiUrl

}