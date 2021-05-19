package com.example.core.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, ViewModelFactoryModule::class])
class CoreModule {

    @Singleton
    @Provides
    fun provideContext(app: DaggerApplication): Context = app.applicationContext

}