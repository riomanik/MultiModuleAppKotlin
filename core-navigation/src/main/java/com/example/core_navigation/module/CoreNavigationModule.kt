package com.example.core_navigation.module

import com.example.core_navigation.NavControllerBinder
import com.example.core_navigation.navigator.CommonNavigator
import com.example.core_navigation.navigator.SplashNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [FeatureNavigationModule::class])
class CoreNavigationModule {

    @Singleton
    @Provides
    fun provideBinder(): NavControllerBinder = NavControllerBinder()

    @Singleton
    @Provides
    fun provideCommonNavigator(binder: NavControllerBinder): CommonNavigator = CommonNavigator(binder)

    @Singleton
    @Provides
    fun provideSplashNavigator(binder: NavControllerBinder): SplashNavigator = SplashNavigator(binder)

}
