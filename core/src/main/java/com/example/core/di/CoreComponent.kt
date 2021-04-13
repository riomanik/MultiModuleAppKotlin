package com.example.core.di

import android.app.Application
import android.content.Context
import androidx.room.RoomDatabase
import com.example.core.common.SharedPrefs
import com.example.core.module.CoreModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {

    fun inject(app: Application)

    fun getContext(): Context

    @Named("APP_DATABASE_NAME")
    fun getDatabaseName(): String

    @Named("BASE_API_URL")
    fun getBaseApiUrl(): String

    fun getNetworkService(): Retrofit

    fun getDatabase(): RoomDatabase

    fun getSharedPref(): SharedPrefs

}