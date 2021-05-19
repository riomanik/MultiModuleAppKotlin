package com.example.core_navigation.module

import com.example.core_navigation.navigation.CommonNavigation
import com.example.core_navigation.navigator.CommonNavigator
import com.example.core_navigation.navigator.SplashNavigator
import com.example.splashscreen_feature.navigation.SplashNavigation
import dagger.Binds
import dagger.Module

@Module
abstract class FeatureNavigationModule {

    @Binds
    abstract fun bindCommonNavigation(navigation: CommonNavigator): CommonNavigation

    @Binds
    abstract fun bindSplashNavigation(navigation: SplashNavigator): SplashNavigation

}
