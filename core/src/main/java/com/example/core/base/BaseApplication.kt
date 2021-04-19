package com.example.core.base

import android.content.Context
import com.example.core.di.CoreComponent
import com.example.core.di.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

abstract class BaseApplication: DaggerApplication() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }

    abstract override fun applicationInjector(): AndroidInjector<out DaggerApplication>

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as BaseApplication).coreComponent
    }

}
