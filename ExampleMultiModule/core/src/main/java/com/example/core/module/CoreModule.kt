package com.example.core.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class, SharedPrefModule::class])
class CoreModule(
    private val app: Application,
    private val databaseName: String,
    private val apiUrl: String
) {

    @Singleton
    @Provides
    fun provideContext(): Context = app.applicationContext

    @Singleton
    @Provides
    @Named("APP_DATABASE_NAME")
    fun provideDatabaseName(): String = databaseName

    @Singleton
    @Provides
    @Named("BASE_API_URL")
    fun provideBaseApiUrl(): String = apiUrl

}