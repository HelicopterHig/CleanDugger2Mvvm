package com.example.cleandugger2mvvm.di

import com.example.domain.repository.Repository
import com.example.domain.usecase.GetWalletInfoUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideWalletUseCase(repository: Repository): GetWalletInfoUseCase {
        return GetWalletInfoUseCase(repository)
    }
}