package com.example.examplemultimodule.app.di.module

import com.example.core.base.scope.ActivityScope
import com.example.core_navigation.module.CoreNavigationModule
import com.example.examplemultimodule.app.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        CoreNavigationModule::class
    ]
)
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}