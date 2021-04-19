package com.example.examplemultimodule

import androidx.multidex.MultiDex
import com.example.core.base.BaseApplication
import com.example.core.di.DaggerCoreComponent
import com.example.examplemultimodule.app.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory()
            .create(DaggerCoreComponent.factory().create(this))
    }
}
