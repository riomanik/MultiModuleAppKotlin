package com.example.core.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, SharedPrefModule::class, DatabaseModule::class])
class CoreModule {

    @Singleton
    @Provides
    fun provideContext(app: Application): Context = app.applicationContext

}