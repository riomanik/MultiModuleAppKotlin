package com.example.core.module

import android.content.Context
import com.example.core.common.CryptoHelper
import com.example.core.common.SharedPrefs
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