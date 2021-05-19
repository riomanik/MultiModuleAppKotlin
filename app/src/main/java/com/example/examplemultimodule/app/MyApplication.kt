package com.example.examplemultimodule.app

import androidx.multidex.MultiDex
import com.example.examplemultimodule.app.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
            .application(this)
            .build()
    }
}
