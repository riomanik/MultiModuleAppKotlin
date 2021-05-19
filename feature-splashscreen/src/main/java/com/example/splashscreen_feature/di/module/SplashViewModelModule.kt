package com.example.splashscreen_feature.di.module

import androidx.lifecycle.ViewModel
import com.example.core.viewmodel.qualifier.ViewModelKey
import com.example.splashscreen_feature.view.viewmodel.SplashScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class SplashViewModelModule {

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewModel::class)
    abstract fun bindLoginViewModel(viewModel: SplashScreenViewModel): ViewModel

}