package com.example.examplemultimodule.app.di

import com.example.examplemultimodule.app.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}