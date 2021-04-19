package com.example.core.di

import android.app.Application
import com.example.core.RoomDatabase
import com.example.core.common.SharedPrefs
import com.example.core.module.CoreModule
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {

    fun getNetworkService(): Retrofit

    fun getDatabaseService(): RoomDatabase

    fun getSharedPref(): SharedPrefs

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): CoreComponent
    }

}