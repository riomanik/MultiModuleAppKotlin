package com.example.examplemultimodule

import android.app.Application
import com.example.core.di.CoreComponent
import com.example.core.di.CoreComponentProvider
import com.example.core.di.DaggerCoreComponent
import com.example.core.module.CoreModule
import com.facebook.stetho.Stetho

class MyApplication : Application(), CoreComponentProvider {

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        coreComponent = DaggerCoreComponent
            .builder()
            .coreModule(
                CoreModule(
                    this,
                    BuildConfig.API_BASE_URL
                )
            )
            .build()
        coreComponent.inject(this)
        Stetho.initializeWithDefaults(this)
    }

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }
}