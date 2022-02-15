package com.example.cleandugger2mvvm.di

import android.content.Context
import com.example.cleandugger2mvvm.presentation.MainViewModelFactory
import com.example.domain.usecase.GetWalletInfoUseCase
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideWalletViewModelFactory(getWalletInfoUseCase: GetWalletInfoUseCase): MainViewModelFactory {
        return MainViewModelFactory(getWalletInfoUseCase)
    }

}