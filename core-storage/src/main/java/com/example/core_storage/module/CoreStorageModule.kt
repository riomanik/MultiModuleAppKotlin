package com.example.core_storage.module

import com.example.core_storage.MyRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Module(includes = [SharedPrefModule::class])
class CoreStorageModule {

    @Singleton
    @Provides
    fun provideDb(application: DaggerApplication) = MyRoomDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideLoginDao(db: MyRoomDatabase) = db.loginDao()

}