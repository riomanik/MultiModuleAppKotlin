package com.example.examplemultimodule.app.di

import com.example.core.di.CoreComponent
import com.example.examplemultimodule.MyApplication
import com.example.examplemultimodule.app.scope.ApplicationScope
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [AndroidInjectionModule::class, ActivityBindingModule::class],
    dependencies = [CoreComponent::class]
)
@ApplicationScope
interface ApplicationComponent: AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory {
        fun create(component: CoreComponent): ApplicationComponent
    }
}
