package com.example.examplemultimodule.di

import com.example.core.di.CoreComponent
import com.example.examplemultimodule.MainActivity
import com.example.examplemultimodule.module.MainActivityModule
import com.example.examplemultimodule.scope.MainActivityScope
import dagger.Component

@MainActivityScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}