package com.example.cleandugger2mvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetWalletInfoUseCase

class MainViewModelFactory(private  val getWalletInfoUseCase: GetWalletInfoUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getWalletInfoUseCase) as T
    }



}