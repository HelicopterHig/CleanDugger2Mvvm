package com.example.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.data.database.CoinDatabase
import com.example.data.model.Coin
import com.example.data.repository.CoinRepositoryInit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CoinViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Coin>>
    private val repositoryInit: CoinRepositoryInit

    init {
        val coinDao = CoinDatabase.getDatabase(application).coinDao()
        repositoryInit = CoinRepositoryInit(coinDao)
        readAllData = repositoryInit.readAllData
    }

    fun addCoin(coin: Coin){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryInit.addCoin(coin)
        }
    }

}