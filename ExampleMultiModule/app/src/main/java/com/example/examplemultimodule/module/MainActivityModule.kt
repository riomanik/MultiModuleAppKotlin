package com.example.examplemultimodule.module

import android.content.Context
import com.example.examplemultimodule.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainActivityModule {

    @Singleton
    @Provides
    fun provideContext(): Context = MyApplication.instance
}