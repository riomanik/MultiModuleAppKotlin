package com.example.examplemultimodule.app.di.component

import com.example.core.module.CoreModule
import com.example.examplemultimodule.app.MyApplication
import com.example.examplemultimodule.app.di.module.ActivityBindingModule
import com.example.examplemultimodule.app.di.module.FeatureBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBindingModule::class,
        FeatureBuilderModule::class,
        CoreModule::class
    ]
)
@Singleton
interface ApplicationComponent: AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: DaggerApplication): Builder

        fun build(): ApplicationComponent
    }

}
