package com.example.core_storage.module

import android.content.Context
import com.example.core_storage.sharedpref.SharedPrefs
import com.example.core_storage.sharedpref.util.CryptoHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPrefModule {

    @Singleton
    @Provides
    fun provideCryptoHelper(context: Context): CryptoHelper {
        return CryptoHelper(context)
    }

    @Singleton
    @Provides
    fun provideSharedPref(context: Context, cryptoHelper: CryptoHelper): SharedPrefs {
        return SharedPrefs(context, cryptoHelper)
    }
}