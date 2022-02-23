package com.example.cleandugger2mvvm.di

import android.content.Context
import com.example.cleandugger2mvvm.presentation.MainViewModelFactory
import com.example.data.dao.CoinDao
import com.example.data.database.CoinDatabase
import com.example.domain.usecase.GetWalletInfoUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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

    @Singleton
    @Provides
    fun getCoinDao(coinDatabase: CoinDatabase): CoinDao {
        return coinDatabase.coinDao()
    }

    @Singleton
    @Provides
    fun getRoomDbInstance(): CoinDatabase {
        return CoinDatabase.getDatabase(provideContext())
    }

}